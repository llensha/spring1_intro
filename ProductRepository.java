package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Авокадо", BigDecimal.valueOf(105.50)));
        products.add(new Product(2, "Грейпфрут", BigDecimal.valueOf(85.75)));
        products.add(new Product(3, "Картофель", BigDecimal.valueOf(33.25)));
        products.add(new Product(4, "Хлеб", BigDecimal.valueOf(0.50)));
        products.add(new Product(5, "Рыба", BigDecimal.valueOf(325.00)));
    }

    public void save(Product product) {
        products.add(product);
    }
}
