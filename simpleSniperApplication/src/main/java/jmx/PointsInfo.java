package jmx;


import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class PointsInfo extends NotificationBroadcasterSupport implements PointsInfoMBean {

    private static int countUserPoints;
    private static int hitsCount;
    private static int failCount;
    private int sequenceNumber = 0;

    public void increment(boolean hit) {
        countUserPoints += 1;
        if (hit) hitsCount += 1;
        else {
//            Notification n = new Notification("points Info", this,
//                    sequenceNumber++, System.currentTimeMillis(),
//                    "Пользователь не попал в область!");
            Notification n = new AttributeChangeNotification(this,
                    failCount++, System.currentTimeMillis(),
                    "Пользователь не попал в область!", "failCount", "int",
                    failCount-1, failCount);
//            failCount++;
            sendNotification(n);
        }
    }

    @Override
    public int getCountUserPoints() {
        return countUserPoints;
    }

    @Override
    public int getCountHitPoints() {
        return hitsCount;
    }

    @Override
    public int getCountFailPoints() {
        return failCount;
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info =
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
}
