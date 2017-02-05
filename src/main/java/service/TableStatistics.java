package service;

import model.Mark;
import model.Visit;

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

    public static int getAverageVisit(Set<Visit> visitSet) {
        int sum = 0;

        if (!visitSet.isEmpty()) {
            for (Visit visit : visitSet) {
                if (visit.getVisit().equals("П")) {
                    sum++;
                }
            }
            int avg = (int) Math.round((double) sum / visitSet.size() * 100);
            return  avg;
        }
        return sum;
    }
}
