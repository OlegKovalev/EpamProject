package database.dao.jdbc;

import model.Days;

public class DaysDao {

    public static Days getDaysByLessonIdAndClassId(int lessonId, int classId) {
        return DataAccess.getEntity(Days.class, "SELECT * FROM days WHERE lesson_id = " + lessonId +
                " AND class_id = " + classId);
    }
}

