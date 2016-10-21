package database.dao.jdbc;

import model.Teacher;

import java.util.List;

public class TeacherDao {

    public static final String SELECT_ALL = "SELECT * FROM teacher";

    public static List<Teacher> getAllTeachers() {
        return DataAccess.getAllEntities(Teacher.class, SELECT_ALL);
    }

    public static Teacher getTeacherById(int id) {
        return DataAccess.getEntity(Teacher.class, SELECT_ALL + " WHERE id = " + id);
    }

    public static void insertTeacher(Teacher newTeacher) {
        DataAccess.execute("INSERT INTO teacher (user_id, lesson_id, class_id) VALUES " +
                "(" + newTeacher.getUserId() + "," + newTeacher.getLessonId() + "," +
                newTeacher.getClassId() + ")");
    }

    public static Teacher getTeacherByLessonIdAndClassId(int lessonId, int classId) {
        return DataAccess.getEntity(Teacher.class, SELECT_ALL + " WHERE lesson_id = " + lessonId +
                " AND class_id = " + classId);
    }

    public static void updateTeacher(Teacher teacher) {
// in the process..
    }

//    duplicates in user_id
    /*public static List<Teacher> getTeacherByUserId(int userId) {
        return DataAccess.getEntity(Teacher.class, SELECT_ALL + " WHERE user_id = " + userId);
    }*/
}
