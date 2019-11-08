package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductItem.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target == null) {
            errors.reject("object.null", "Product item is null");
            return;
        }
        ProductItem item = (ProductItem) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "The item name is empty");
        if (item.getPrice() == null || item.getPrice() <= 0) {
            errors.rejectValue("price", "price.null", "The price is 0 or negative");
        }
    }
}