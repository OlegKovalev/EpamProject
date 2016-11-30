package model;

public class Mark {

    private int id;
    private int lessonId;
    private int studentId;
    private int mark;
    private int day;
    
/*
    public Mark(int id, int lessonId, int studentId, int day, int mark) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.day = day;
        this.mark = mark;
    }
*/

    public void setId(int id) {
        this.id = id;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setDay(int day) {
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
