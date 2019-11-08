package by.pvt;

import by.pvt.product.ProductItemValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.pvt")
public class WebAppTestConfiguration {

    @Bean
    ProductItemValidator productItemValidator() {
        return new ProductItemValidator();
    }

}
