package database.dao.jdbc;

import model.Teacher;

import java.util.List;
import java.util.Set;

public class TeacherDao {

    public static final String SELECT_ALL = "SELECT * FROM teacher";

    public static Set<Teacher> getAllTeachers() {
        return DataAccess.getAllEntities(Teacher.class, SELECT_ALL);
    }

    public static Teacher getTeacherById(int id) {
        return DataAccess.getEntity(Teacher.class, SELECT_ALL + " WHERE id = " + id);
    }

    public static Set<Teacher> getTeacherByUserId(int userId) {
        return DataAccess.getAllEntities(Teacher.class, SELECT_ALL + " WHERE user_id = " + userId);
    }

    public static void insertTeacher(Teacher newTeacher) {
        DataAccess.execute("INSERT INTO teacher (user_id, lesson_id, class_id) VALUES " +
                "(" + newTeacher.getUser_id() + "," + newTeacher.getLesson_id() + "," +
                newTeacher.getClass_id() + ")");
    }

    public static Teacher getTeacherByLessonIdAndClassId(int lessonId, int classId) {
        return DataAccess.getEntity(Teacher.class, SELECT_ALL + " WHERE lesson_id = " + lessonId +
                " AND class_id = " + classId);
    }

    public static void updateTeacher(Teacher teacher) {
// in the process..
    }
}
