package model;

public class Mark {

    private int id;
    private int lesson_id;
    private int student_id;
    private int day;
    private int mark;
    
/*
    public Mark(int id, int lesson_id, int student_id, int day, int mark) {
        this.id = id;
        this.lesson_id = lesson_id;
        this.student_id = student_id;
        this.day = day;
        this.mark = mark;
    }
*/

    public void setId(int id) {
        this.id = id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getDay() {
        return day;
    }

    public int getMark() {
        return mark;
    }
}
