package service;

import model.Mark;

import java.util.Set;

public class TableStatistics {

    public static double getAverageMark(Set<Mark> markSet) {
        double sum = 0;

        if (!markSet.isEmpty()) {
            for (Mark mark : markSet) {
                sum += mark.getMark();
            }
            int avg = (int) Math.round(sum / markSet.size() * 100);
            return (double) avg / 100;
        }
        return sum;
    }
}
