package model;

public class Class {
    
    private int id;
    private int number;

    private String prefix;

    public Class(int id, int number, String prefix) {
        this.id = id;
        this.number = number;
        this.prefix = prefix;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getPrefix() {
        return prefix;
    }
}
