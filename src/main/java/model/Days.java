package model;

public class Days {

    private int id;
    private int lesson_id;
    private int class_id;
    private int count;
    
   /* public Days(int id, int lesson_id, int class_id, int count) {
        this.id = id;
        this.lesson_id = lesson_id;
        this.class_id = class_id;
        this.count = count;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getCount() {
        return count;
    }
}
