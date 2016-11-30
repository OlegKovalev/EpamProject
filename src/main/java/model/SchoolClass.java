package model;

public class SchoolClass {

    private int id;
    private int number;
    private String prefix;

    /*public SchoolClass(int id, int number, String prefix) {
        this.id = id;
        this.number = number;
        this.prefix = prefix;
    }*/

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
