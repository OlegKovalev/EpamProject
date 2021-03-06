package database.dao.jdbc;

import model.Lesson;
import model.Mark;
import model.SchoolClass;
import model.Student;

import java.util.List;
import java.util.Set;

public class MarkDao {

    public static final String SELECT_ALL = "SELECT * FROM mark";

    public static Set<Mark> getMarksByLessonAndStudent(Lesson lesson, Student student) {
        return DataAccess.getAllEntities(Mark.class, SELECT_ALL + " WHERE lesson_id = " + lesson.getId() +
                " AND student_id = " + student.getId());
    }

    public static Mark getMarkByLessonIdAndStudentIdAndDay(int lessonId, int studentId, int day) {
        return DataAccess.getEntity(Mark.class, SELECT_ALL + " WHERE lesson_id = " + lessonId +
                " AND student_id = " + studentId + " AND day = " + day);
    }

    public static void insertMark(Mark newMark) {
        DataAccess.execute("INSERT INTO mark (lesson_id, student_id, day, mark) VALUES " +
                "(" + newMark.getLesson_id() + "," + newMark.getStudent_id() + "," + newMark.getDay() +
                "," + newMark.getMark() + ")");
    }

    public static void updateMark(Mark mark) {
        DataAccess.execute("UPDATE mark SET mark = " + mark.getMark() + " WHERE lesson_id = " + mark.getLesson_id() +
                " AND student_id = " + mark.getStudent_id() + " AND day = " + mark.getDay());
    }
}
