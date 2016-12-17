package model;

public class SchoolClass implements Comparable {

    private int id;
    private int number;
    private String prefix;

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

    @Override
    public int compareTo(Object obj) {
        SchoolClass entry = (SchoolClass) obj;

        long result = number - entry.number;
        if (result != 0) {
            return (int) (result / Math.abs(result));
        }

        result = prefix.compareTo(entry.prefix);
        if (result != 0) {
            return (int) result;
        }
        return 0;
    }
}
