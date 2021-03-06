package model.table;

import model.Student;
import model.Visit;

import java.util.Set;

public class VisitTable {
   
    private Student student;
    private Set<Visit> visits;
    private int averageVisit;

    public VisitTable(Student student, Set<Visit> marks, int averageVisit) {
        this.student = student;
        this.visits = marks;
        this.averageVisit = averageVisit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> marks) {
        this.visits = marks;
    }

    public int getAverageVisit() {
        return averageVisit;
    }

    public void setAverageVisit(int averageVisit) {
        this.averageVisit = averageVisit;
    }
}
