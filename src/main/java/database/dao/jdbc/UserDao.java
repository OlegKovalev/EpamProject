package database.dao.jdbc;

import model.User;
import org.apache.log4j.Logger;

public class UserDao {

    public static final String SELECT_ALL = "SELECT * FROM user";

    public static User getUserByLogin(String login) {
        return DataAccess.getEntity(User.class, SELECT_ALL + " WHERE login = '" + login + "'");
    }

    public static void insertUser(User newUser) {
        DataAccess.execute("INSERT INTO user (login, pass, fullName) VALUES " +
                "('" + newUser.getLogin() + "','" + newUser.getPass() + "','" + newUser.getFullName() + "')");
    }
}
