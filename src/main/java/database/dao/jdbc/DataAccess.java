package database.dao.jdbc;

import database.connectionpool.ConnectionPool;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

public abstract class DataAccess {
    private static final Logger LOG = Logger.getLogger(DataAccess.class);

    public static <T> T getEntity(Class<T> tClass, String sql) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                if (resultSet.next()) {
                    return getT(tClass, resultSet);
                }
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            LOG.error("", e);
        }
        return null;
    }

    public static <T> Set<T> getAllEntities(Class<T> tClass, String sql) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                Set<T> result = new TreeSet<>();
                while (resultSet.next()) {
                    T instance = getT(tClass, resultSet);
                    result.add(instance);
                }
                return result;
            }
        } catch (IllegalAccessException | InstantiationException | SQLException e) {
            LOG.info(sql);
            LOG.error("", e);
        }
        return null;
    }

    public static void execute(String sql) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            LOG.error("", e);
        }
    }

    private static <T> T getT(Class<T> tClass, ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException {
        T instance = tClass.newInstance();
        for (Field field : tClass.getDeclaredFields()) {
            setField(field, instance, resultSet);
        }
        return instance;
    }

    private static <T> void setField(Field field, T object, ResultSet resultSet) {
        field.setAccessible(true);
        String name = field.getName();
        Class<?> type = field.getType();
        try {
            if (type.equals(int.class)) {
                field.setInt(object, resultSet.getInt(name));
            } else if (type == String.class) {
                field.set(object, resultSet.getString(name));
            } else if (type == float.class) {
                field.setFloat(object, resultSet.getFloat(name));
            }
        } catch (SQLException | IllegalAccessException e) {
            LOG.error("", e);
        }
    }
}
