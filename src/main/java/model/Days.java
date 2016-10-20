package model;

public class Days {

    private int id;
    private int lessonId;
    private int classId;
    private int count;

    public Days(int id, int lessonId, int classId, int count) {
        this.id = id;
        this.lessonId = lessonId;
        this.classId = classId;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getClassId() {
        return classId;
    }

    public int getCount() {
        return count;
    }
}
