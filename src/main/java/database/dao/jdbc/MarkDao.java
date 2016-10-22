package database.dao.jdbc;

import model.Lesson;
import model.Mark;
import model.SchoolClass;

import java.util.List;

public class MarkDao {

    public static final String SELECT_ALL = "SELECT * FROM mark";

    public static List<Mark> getMarkByLessonAndClass(Lesson lesson, SchoolClass schoolClass) {
        return DataAccess.getAllEntities(Mark.class, SELECT_ALL + " WHERE student_id IN" +
                "(SELECT id FROM student WHERE class_id = " + schoolClass.getId() + ") AND lesson_id = " +
                lesson.getId());
    }

    public static void insertMark(Mark newMark) {
        DataAccess.execute("INSERT INTO mark (lesson_id, student_id, day, mark) VALUES " +
                "(" + newMark.getLessonId() + "," + newMark.getStudentId() + "," + newMark.getDay() +
                "," + newMark.getMark() + ")");
    }

    public static void updateMark(Mark mark) {
        DataAccess.execute("UPDATE mark SET mark = " + mark.getMark() + " WHERE lesson_id = " + mark.getLessonId() +
                " AND student_id = " + mark.getStudentId() + " AND day = " + mark.getDay());
    }
}
