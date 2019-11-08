package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ProductItemRepository {

    private static Logger log = Logger.getLogger("ProductItemRepository");

    @Autowired
    SessionFactory sessionFactory;

    public List<ProductItem> findProduct(int count, boolean isTopProduct) {
        log.info("Call findProduct()");
        return sessionFactory.getCurrentSession()
                .createQuery("from ProductItem", ProductItem.class)
                //.setParameter("param1", isTopProduct)
                .setMaxResults(count)
                .list();
    }

    public List<ProductItem> findProductByName(String searchStr) {
        log.info("Call findProductByName()");
        return sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.name like :param1", ProductItem.class)
                .setParameter("param1", "%" + searchStr + "%")
                .setMaxResults(10)
                .list();
    }

    public ProductItem findProductById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(ProductItem.class, id);
    }

    public void save(ProductItem productItem) {
        sessionFactory.getCurrentSession()
                .persist(productItem);
    }

    public List<ProductItem> findProductByDate(Date lastDate) {
        return sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.updateDate > :param", ProductItem.class)
                .setParameter("param", lastDate)
                .list();
    }
}