package database.dao.jdbc;

import model.Lesson;
import model.Student;
import model.Visit;

import java.util.Set;

public class VisitDao {

    public static final String SELECT_ALL = "SELECT * FROM visit";

    public static Set<Visit> getVisitsByLessonAndStudent(Lesson lesson, Student student) {
        return DataAccess.getAllEntities(Visit.class, SELECT_ALL + " WHERE lesson_id = " + lesson.getId() + 
                " AND student_id = " + student.getId());
    }

    public static void insertVisit(Visit newVisit) {
        DataAccess.execute("INSERT INTO visit (lesson_id, student_id, day, visit) VALUES " +
                "(" + newVisit.getLesson_id() + "," + newVisit.getStudent_id() + "," + newVisit.getDay() +
                ",'" + newVisit.getVisit() + "')");
    }
}
