package model;

public class Visit {
    
    private int id;
    private int lessonId;

    private int studentId;

    private int day;
    public Visit(int id, int lessonId, int studentId, int day) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
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

    public int getDay() {
        return day;
    }
}
