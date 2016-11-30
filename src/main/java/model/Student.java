package model;

public class Student {

    private int id;
    private int classId;
    private String fio;
    
    /*public Student(int id, int classId, String fio) {
        this.id = id;
        this.classId = classId;
        this.fio = fio;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setFio(String fio) {
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
