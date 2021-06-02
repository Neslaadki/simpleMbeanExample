package jmx;

import resources.Point;

import java.util.List;

public class HitPercent implements HitPercentMBean {


    private double percent;

    public void calculate(List<Point> points) {
        int hits = 0;
        for (Point point : points) {
            if (point.isHit()) hits++;
        }
        percent = (double) hits / points.size();
    }

    @Override
    public double getHitPercent() {
        return percent;
    }

    @Override
    public void sayMessage(String message) {
        System.out.println(message);
    }

}
