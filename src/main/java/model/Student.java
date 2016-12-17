package model;

public class Student implements Comparable {

    private int id;
    private int class_id;
    private String fullName;

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

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;

        int result = fullName.compareTo(student.fullName);
        if(result != 0) {
            return result;
        }

        result = id - student.id;
        if(result != 0) {
            return result / Math.abs( result );
        }
        return 0;
    }
}
