package database.dao.jdbc;

import model.Lesson;
import model.SchoolClass;
import model.Visit;

import java.util.List;

public class VisitDao {

    public static final String SELECT_ALL = "SELECT * FROM visit";

    public static List<Visit> getAllVisitsByLessonAndClass(Lesson lesson, SchoolClass schoolClass) {
        return DataAccess.getAllEntities(Visit.class, SELECT_ALL + " WHERE student_id IN" +
                "(SELECT id FROM student WHERE class_id = " + schoolClass.getId() + ") AND lesson_id = " +
                lesson.getId());
    }

    public static void insertVisit(Visit newVisit) {
        DataAccess.execute("INSERT INTO visit (lesson_id, student_id, day, visit) VALUES " +
                "(" + newVisit.getLessonId() + "," + newVisit.getStudentId() + "," + newVisit.getDay() +
                ",'" + newVisit.getVisit() + "')");
    }
}
