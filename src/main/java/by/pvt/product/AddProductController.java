package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add")
public class AddProductController {

    private static Logger log = Logger.getLogger("AddProductController");

    @Autowired
    ProductCatalogService productCatalogService;

    @Autowired
    ProductItemValidator validator;

    @GetMapping
    public String showAddPage() {
        return "addPage";
    }

    @PostMapping("/product")
    public String addNewProduct(
            @ModelAttribute("item") ProductItem productItem,
            @RequestParam(value = "isTopProduct", required = false) boolean isTopProduct,
            @RequestParam("image") MultipartFile file,
            BindingResult result,
            Model model) throws IOException {
        log.info("New product: " + productItem + " isTopProduct=" + isTopProduct);
        validator.validate(productItem, result);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "addPage";
        }
        if (!file.isEmpty() && productItem != null) {
            byte[] bytes = file.getBytes();
            log.info("IMAGE BYTES: " + bytes.length);
            productItem.setPicture(bytes);
            productCatalogService.saveNewProduct(productItem);
            return "redirect:/home";
        }

        return "error";
    }

}