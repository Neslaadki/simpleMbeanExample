package services;

import jmx.HitPercent;
import jmx.PointsInfo;
import resources.Point;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;


public class PointsHandler {

    private final List<Point> points = new ArrayList();
    private PointsInfo pointsInfoBean;
    private HitPercent hitPercent;

    public PointsHandler() {
        try {

            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            ObjectName firstBean = new ObjectName("jmx:type=PointsInfo");
            ObjectName secondBean = new ObjectName("jmx:type=HitPercent");

            hitPercent = new HitPercent();
            pointsInfoBean = new PointsInfo();

            mBeanServer.registerMBean(pointsInfoBean, firstBean);
            mBeanServer.registerMBean(hitPercent, secondBean);

        } catch (MBeanRegistrationException | InstanceAlreadyExistsException | NotCompliantMBeanException | MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    public void add(Point point) {
        points.add(point);
        if (point.isHit()) System.out.println("Попал!");
        else System.out.println("Не попал!");

        pointsInfoBean.increment(point.isHit());
        hitPercent.calculate(points);

    }

    public void show() {
        if (points.isEmpty()) System.out.println("Пусто! Ты не выстрелил ни разу!");
        for (Point point : points) {
            System.out.println(point.toString());
        }
    }
}
