package database.dao.jdbc;

import model.Days;

public class DaysDao {

//    public static final String SELECT_ALL = "SELECT * FROM days";

    public static Days getDaysByLessonIdAndClassId(int lessonId, int classId) {
        return DataAccess.getEntity(Days.class, "SELECT * FROM days WHERE lesson_id = " + lessonId +
                " AND class_id = " + classId);
    }

    public static void updateClass(Days days) {
        DataAccess.execute("UPDATE days SET count = " + days.getCount() + " WHERE lesson_id = " + days.getLesson_id() +
                " AND class_id = " + days.getClass_id());
    }
}

