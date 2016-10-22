package database.dao.jdbc;

import model.User;

public class UserDao {

    public static final String SELECT_ALL = "SELECT * FROM user";

    public static User getUserById(int userId) {
        return DataAccess.getEntity(User.class, SELECT_ALL + " WHERE id = " + userId);
    }

    public static User getUserByLogin(String login) {
        return DataAccess.getEntity(User.class, SELECT_ALL + " WHERE login = " + login);
    }
    
    public static void insertUser(User newUser) {
        DataAccess.execute("INSERT INTO user (login, pass, fio) VALUES " +
                "('" + newUser.getLogin() + "','" + newUser.getPass() + "','" + newUser.getFio() + "')");
    }

    public static void updateUserPass(User user) {
        DataAccess.execute("UPDATE user SET pass = " + user.getPass() + " WHERE login = " + user.getLogin() +
                " AND fio = " + user.getFio());
    }
}
