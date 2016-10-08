package model;

public class Elective {
    
    private int id;
    private int lessonId;
    private int studentId;

    private String comment;

    public Elective(int id, int lessonId, int studentId, String comment) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }
}
