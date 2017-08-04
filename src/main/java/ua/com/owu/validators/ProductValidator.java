package ua.com.owu.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.entity.Product;
import ua.com.owu.service.ProductService;

import java.util.List;
import java.util.stream.Stream;

@Component
public class ProductValidator implements Validator {
    @Autowired
    private ProductService productService;

    public boolean supports(Class<?> clazz) {
        return clazz.equals(Product.class);
    }

    public void validate(Object target, Errors errors) {
        final Product product = (Product) target;
        final List<Product> all = productService.findAll();
        Stream<Product> stream = all.stream();
        stream.forEach((p) -> {
            if (product.getProdname().equals(p.getProdname() == null ? "" : p.getProdname())) {
                errors.rejectValue( "prodname",
                        "xxx",
                        "product name is exists");
            }

        });

    }
}
