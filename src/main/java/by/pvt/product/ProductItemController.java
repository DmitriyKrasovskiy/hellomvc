package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductItemController {

    @Autowired
    ProductCatalogService productCatalogService;

    @GetMapping("/item/{id}")
    public String showProductItem(@PathVariable Long id, Model model) {
        ProductItem productItem = productCatalogService.getProductItem(id);
        model.addAttribute("item", productItem);
        return "productItemPage";
    }

    @GetMapping("item/{id}/image")
    public @ResponseBody
    byte[] showProductImage(@PathVariable Long id) {
        return productCatalogService.getProductItem(id).getPicture();
    }

}