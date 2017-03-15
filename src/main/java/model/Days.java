package model;

public class Days implements Comparable {

    private int id;
    private int lesson_id;
    private int class_id;
    private int count;

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

    @Override
    public int compareTo(Object o) {
        Days days = (Days) o;

        long result = id - days.id;
        if (result != 0) {
            return (int) (result / Math.abs(result));
        }
        return 0;
    }
//    
}
