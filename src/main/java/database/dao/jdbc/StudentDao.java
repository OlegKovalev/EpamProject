package database.dao.jdbc;

import model.Student;

import java.util.List;
import java.util.Set;

public class StudentDao {

    public static final String SELECT_ALL = "SELECT * FROM student";

    public static Set<Student> getAllStudentsByClassId(int classId) {
        return DataAccess.getAllEntities(Student.class, SELECT_ALL + " WHERE class_id = " + classId);
    }
}
