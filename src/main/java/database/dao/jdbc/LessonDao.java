package database.dao.jdbc;

import model.Lesson;

import java.util.Set;

public class LessonDao {

    public static final String SELECT_ALL = "SELECT * FROM lesson";

    public static Set<Lesson> getAllLessons() {
        return DataAccess.getAllEntities(Lesson.class, SELECT_ALL);
    }

    public static Lesson getLessonById(int id) {
        return DataAccess.getEntity(Lesson.class, SELECT_ALL + " WHERE id = " + id);
    }

    public static Lesson getLessonByName(String name) {
        return DataAccess.getEntity(Lesson.class, SELECT_ALL + " WHERE name = '" + name + "'");
    }

    public static void insertLesson(Lesson newLesson) {
        DataAccess.execute("INSERT INTO lesson (name) VALUES " + "('" + newLesson.getName() + "')");
    }
}
