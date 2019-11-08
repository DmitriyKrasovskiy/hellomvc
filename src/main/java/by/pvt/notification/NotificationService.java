package by.pvt.notification;

import by.pvt.pojo.ProductItem;
import by.pvt.product.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class NotificationService {

    private static final Logger log = Logger.getLogger("NotificationService");

    private Set<ProductItem> newProductItems;

    @Autowired
    NotificationRepo notificationRepo;

    @Autowired
    ProductItemRepository productItemRepository;

    @Scheduled(cron = "0/5 * * * * *")
    @Transactional
    public void executeNotification() {
        log.info("do new notification");

        Date lastDate = notificationRepo.getLastDate();
        List<ProductItem> newProducts =
                productItemRepository.findProductByDate(lastDate);
        if (!newProducts.isEmpty()) {
            getNewProductItems().clear();
            getNewProductItems().addAll(newProducts);
            notificationRepo.updateDate();
        }
    }

    public Set<ProductItem> getNewProductItems() {
        if (newProductItems == null) {
            newProductItems = new HashSet<>();
        }
        return newProductItems;
    }

    public void setNewProductItems(Set<ProductItem> newProductItems) {
        this.newProductItems = newProductItems;
    }
}