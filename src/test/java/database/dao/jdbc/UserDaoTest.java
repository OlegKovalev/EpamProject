package database.dao.jdbc;

import model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleg on 27.11.2016.
 */
public class UserDaoTest {
    
    UserDao userDao;
    
    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
    }

    @Test
    public void getUserById() throws Exception {

    }

    @Test
    public void getUserByLogin() throws Exception {

    }

    @Test
    @Ignore
    public void insertUser() throws Exception {
        User user = new User();
        user.setLogin("test");
        user.setPass("test");
        user.setFullName("тест");
        userDao.insertUser(user);
    }

    @Test
    public void updateUserPass() throws Exception {

    }

}