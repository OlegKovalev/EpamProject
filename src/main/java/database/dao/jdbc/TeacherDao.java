package database.dao.jdbc;

import model.Teacher;

import java.util.Set;

public class TeacherDao {

    public static final String SELECT_ALL = "SELECT * FROM teacher";

    public static Set<Teacher> getTeacherByUserId(int userId) {
        return DataAccess.getAllEntities(Teacher.class, SELECT_ALL + " WHERE user_id = " + userId);
    }
}
