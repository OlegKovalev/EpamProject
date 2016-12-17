package model.table;

import model.Mark;
import model.Student;

import java.util.Set;

public class MarkTable {

    private Student student;
    private Set<Mark> marks;
    private double averageMark;

    public MarkTable(Student student, Set<Mark> marks, double averageMark) {
        this.student = student;
        this.marks = marks;
        this.averageMark = averageMark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
