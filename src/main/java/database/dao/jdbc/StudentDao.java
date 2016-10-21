package database.dao.jdbc;

import model.Student;

import java.util.List;

public class StudentDao {

    public static final String SELECT_ALL = "SELECT * FROM student";

    public static List<Student> getAllStudentsByClassId(int classId) {
        return DataAccess.getAllEntities(Student.class, SELECT_ALL + "WHERE class_id = " + classId);
    }

    public static Student getStudentById(int id) {
        return DataAccess.getEntity(Student.class, SELECT_ALL + " WHERE id = " + id);
    }
}
