package by.pvt.user;

import by.pvt.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class AppUserRepository {

    private static Logger log = Logger.getLogger("AppUserRepository");

    @Autowired
    SessionFactory sessionFactory;

    public Integer findUserCountByLogin(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser where username like :param1", AppUser.class)
                .setParameter("param1", username)
                .list()
                .size();
    }

    public void save(AppUser user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public AppUser findUserByLogin(String username) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppUser where username like :param1", AppUser.class)
                    .setParameter("param1", username)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}