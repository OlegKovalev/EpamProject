package database.dao.jdbc;

import model.Lesson;
import model.SchoolClass;
import model.Visit;

import java.util.List;
import java.util.Set;

public class VisitDao {

    public static final String SELECT_ALL = "SELECT * FROM visit";

    public static Set<Visit> getAllVisitsByLessonAndClass(Lesson lesson, SchoolClass schoolClass) {
        return DataAccess.getAllEntities(Visit.class, SELECT_ALL + " WHERE student_id IN" +
                "(SELECT id FROM student WHERE class_id = " + schoolClass.getId() + ") AND lesson_id = " +
                lesson.getId());
    }

    public static void insertVisit(Visit newVisit) {
        DataAccess.execute("INSERT INTO visit (lesson_id, student_id, day, visit) VALUES " +
                "(" + newVisit.getLesson_id() + "," + newVisit.getStudent_id() + "," + newVisit.getDay() +
                ",'" + newVisit.getVisit() + "')");
    }
}
