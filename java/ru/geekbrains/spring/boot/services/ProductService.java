package ru.geekbrains.spring.boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.boot.models.Product;
import ru.geekbrains.spring.boot.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAll(BigDecimal minCost, BigDecimal maxCost) {
        List<Product> out = findAll();
        if (minCost != null) {
            out = out.stream().filter(p -> p.getCost().compareTo(minCost) >= 0).collect(Collectors.toList());
        }
        if (maxCost != null) {
            out = out.stream().filter(p -> p.getCost().compareTo(maxCost) <= 0).collect(Collectors.toList());
        }
        return out;
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.saveOrUpdate(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
