package model;

public class Teacher {
    
    private int id;
    private int userId;
    private int lessonId;

    private int classId;

    public Teacher(int id, int userId, int lessonId, int classId) {
        this.id = id;
        this.userId = userId;
        this.lessonId = lessonId;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getClassId() {
        return classId;
    }
}
