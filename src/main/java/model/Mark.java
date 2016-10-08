package model;

public class Mark {
    
    private int id;
    private int lessonId;

    private int studentId;

    private int mark;
    private int day;
    public Mark(int id, int lessonId, int studentId, int mark, int day) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.mark = mark;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getMark() {
        return mark;
    }

    public int getDay() {
        return day;
    }
}
