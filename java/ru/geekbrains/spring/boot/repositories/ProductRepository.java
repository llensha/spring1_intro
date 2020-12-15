package ru.geekbrains.spring.boot.repositories;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring.boot.models.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Авокадо", BigDecimal.valueOf(105.50)),
                new Product(2L, "Грейпфрут", BigDecimal.valueOf(85.75)),
                new Product(3L, "Картофель", BigDecimal.valueOf(33.25)),
                new Product(4L, "Хлеб", BigDecimal.valueOf(0.50)),
                new Product(5L, "Рыба", BigDecimal.valueOf(325.00))
        ));
    }

    public Product saveOrUpdate(Product product) {
        if (product.getId() != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i, product);
                    return product;
                }
            }
        }
        Long newId = products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        product.setId(newId);
        products.add(product);
        return product;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
