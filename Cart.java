package ru.geekbrains.spring.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Cart {
    private List<Product> cart;
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getCart() {
        return cart;
    }

    public boolean add(int id) {
        Product product = productRepository.getProduct(id);
        if (product != null) {
            cart.add(product);
            return true;
        }
        return false;
    }

    public Product remove(int id) {
        Product product = productRepository.getProduct(id);
        if (product != null) {
            if (cart.contains(product)) {
                cart.remove(product);
                System.out.println(product + " removed");
                return product;
            } else {
                System.out.println("Cart doesn't contains " + product);
            }
        }
        return product;
    }



}
