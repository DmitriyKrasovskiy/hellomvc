package by.pvt.user;

import by.pvt.pojo.AppRole;
import by.pvt.pojo.RoleName;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class AppRoleRepository {

    private static Logger log = Logger.getLogger("AppRoleRepository");

    @Autowired
    SessionFactory sessionFactory;

    public AppRole findRoleByName(RoleName roleName) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppRole where roleName like :param1", AppRole.class)
                    .setParameter("param1", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    public List<String> getRoleNames() {
        return sessionFactory.getCurrentSession()
                .createQuery("select roleName from AppRole", RoleName.class)
                .list()
                .stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}