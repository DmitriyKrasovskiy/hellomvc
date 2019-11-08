package by.pvt;

import by.pvt.notification.NotificationService;
import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;
import java.util.logging.Logger;

@Controller
@RequestMapping("/home")
public class HomeController {

    private static Logger log = Logger.getLogger("HomeController");

    @Autowired
    NotificationService notificationService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(Model model) {
        log.info("Call showHomePage()");

        Set<ProductItem> newProductItems = notificationService.getNewProductItems();
        model.addAttribute("items", newProductItems);
        log.info("Items size=" + newProductItems.size());
        return "homePage";
    }

}