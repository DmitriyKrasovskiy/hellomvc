package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    ProductCatalogService productCatalogService;

    @GetMapping
    public String search(@RequestParam String searchStr, Model model) {
        List<ProductItem> items = productCatalogService.searchProduct(searchStr);
        model.addAttribute("items", items);
        return "searchResultPage";
    }

}