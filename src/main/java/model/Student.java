package model;

public class Student {

    private int id;
    private int class_id;
    private String fullName;
    
    /*public Student(int id, int class_id, String fullName) {
        this.id = id;
        this.class_id = class_id;
        this.fullName = fullName;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public int getClass_id() {
        return class_id;
    }

    public String getFullName() {
        return fullName;
    }
}
