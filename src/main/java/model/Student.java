package model;

public class Student {

    private int id;
    private int classId;
    private String fio;

    public Student(int id, int classId, String fio) {
        this.id = id;
        this.classId = classId;
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public String getFio() {
        return fio;
    }
}
