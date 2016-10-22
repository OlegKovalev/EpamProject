package model;

public class User {

    private int id;
    private String login;
    private String pass;
    private String fio;

    public User(int id, String login, String pass, String fio) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getFio() {
        return fio;
    }
}
