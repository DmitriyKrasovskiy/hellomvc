package by.pvt.notification;

import by.pvt.pojo.Notification;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.logging.Logger;

@Repository
public class NotificationRepo {

    private static final Logger log = Logger.getLogger("NotificationRepo");

    @Autowired
    SessionFactory sessionFactory;

    public void updateDate() {
        Notification notification = null;
        try {
            notification = sessionFactory.getCurrentSession().find(Notification.class, 1L);
        } catch (HibernateException e) {
            log.info(e.getMessage() + " ignored");
        }
        if (notification == null) {
            notification = new Notification(1L, new Date());
        } else {
            notification.setUpdateDate(new Date());
        }
        sessionFactory.getCurrentSession().saveOrUpdate(notification);
    }

    public Date getLastDate() {
        try {
            return sessionFactory.getCurrentSession().find(Notification.class, 1L)
                    .getUpdateDate();
        } catch (Exception e) {
            log.info(e.getMessage() + " ignored");
            return null;
        }
    }
}
