package model;

public class User implements Comparable {

    private int id;
    private String login;
    private String pass;
    private String fullName;

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }
    
    @Override
    public String toString(){
        return login;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;

        long result = id - user.id;
        if (result != 0) {
            return (int) (result / Math.abs(result));
        }
        return 0;
    }
}
