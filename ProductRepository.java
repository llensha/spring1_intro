package ru.geekbrains.spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
        System.out.println("Unknown product");
        return null;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Avocado", 105.50));
        products.add(new Product(2, "Grapefruit", 85.75));
        products.add(new Product(3, "Potato", 33.25));
        products.add(new Product(4, "Bread", 0.50));
        products.add(new Product(5, "Fish", 325.00));



    }
}
