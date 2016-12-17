package model;

public class Teacher implements Comparable {

    private int id;
    private int user_id;
    private int lesson_id;
    private int class_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public int getClass_id() {
        return class_id;
    }

    @Override
    public int compareTo(Object o) {
        Teacher teacher = (Teacher) o;

        long result = id - teacher.id;
        if (result != 0) {
            return (int) (result / Math.abs(result));
        }
        return 0;
    }
}
