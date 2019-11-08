package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private static Logger log = Logger.getLogger("CatalogController");

    @Autowired
    ProductCatalogService productCatalogService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCatalog( Model model ) {
        log.info("Call showCatalog()");
        List<ProductItem> items = productCatalogService.getTopProducts();
        model.addAttribute("items", items);
        return "catalogPage";
    }

}