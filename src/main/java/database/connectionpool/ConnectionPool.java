package database.connectionpool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
    public static final Logger LOG = Logger.getLogger(ConnectionPool.class);

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("connectionpool.db");
    private static final String URL = BUNDLE.getString("db.url");
    private static final String DRIVER = BUNDLE.getString("db.driver");
    private static final String PASSWORD = BUNDLE.getString("db.password");
    private static final String USERNAME = BUNDLE.getString("db.username");

    private int poolSize = Integer.parseInt(BUNDLE.getString("db.poolsize"));
    private BlockingQueue<PooledConnection> freeConnections;
    private Set<Object> usedConnections;

    private static volatile ConnectionPool instance;

    ConnectionPool() {
        freeConnections = new ArrayBlockingQueue<>(poolSize);
        usedConnections = Collections.synchronizedSet(new HashSet<>(poolSize));
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOG.fatal("DB Driver has not been loaded.", e);
            return;
        }
        try {
            for (int i = 0; i < poolSize; i++) {
                Connection connection =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
                freeConnections.add(new PooledConnection(connection));
            }
        } catch (SQLException e) {
            LOG.error("Can't get connection from Driver Manager.", e);
        }

    }

    public static ConnectionPool getInstance() {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionPool.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConnectionPool();
                }
            }
        }
        return localInstance;
    }

    public Connection getConnection() throws SQLException {
        PooledConnection connection = null;
        try {
            connection = freeConnections.poll(1, TimeUnit.SECONDS);
            if (connection == null) {
                LOG.warn("Waiting more than 1 second");
                connection = freeConnections.poll(5, TimeUnit.SECONDS);
                if (connection == null) {
                    throw new SQLException("No free connection for 5 seconds.");
                }
            }
            usedConnections.add(connection);
        } catch (InterruptedException e) {
            throw new SQLException(e);
        }
        return (Connection) connection;
    }

    public void free(PooledConnection pooledConnection) {
        usedConnections.remove(pooledConnection);
        freeConnections.offer(pooledConnection);
    }
}
