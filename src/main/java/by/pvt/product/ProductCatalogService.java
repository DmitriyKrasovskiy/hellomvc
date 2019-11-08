package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class ProductCatalogService {

    private static Logger log = Logger.getLogger("ProductCatalogService");


    @Autowired
    ProductItemRepository repository;

    @Transactional
    public List<ProductItem> getTopProducts() {
        log.info("Call getTopProducts()");
        return repository.findProduct(10, true);
    }

    @Transactional
    public List<ProductItem> searchProduct(String searchStr) {
        if (searchStr == null || searchStr.isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findProductByName(searchStr);
    }

    @Transactional
    public ProductItem getProductItem(Long id) {
        return repository.findProductById(id);
    }

    @Transactional
    public void saveNewProduct(ProductItem productItem) {
        if (productItem.getUpdateDate() == null) {
            productItem.setUpdateDate(new Date());
        }
        repository.save(productItem);
    }
}