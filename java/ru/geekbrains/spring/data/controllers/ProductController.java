package ru.geekbrains.spring.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.data.models.Product;
import ru.geekbrains.spring.data.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll(Sort.by("cost"));
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/search_by_min_cost")
    public List<Product> searchByMinCost(@RequestParam(name = "min_cost") Integer minCost) {
        return productRepository.findAllByCostIsGreaterThanEqualOrderByCost(minCost);
    }

    @GetMapping("/search_by_max_cost")
    public List<Product> searchByMaxCost(@RequestParam(name = "max_cost") Integer maxCost) {
        return productRepository.findAllByCostIsLessThanEqualOrderByCost(maxCost);
    }

    @GetMapping("/search_by_min_and_max_cost")
    public List<Product> searchByMinAndMaxCost(@RequestParam(name = "min_cost") Integer minCost,
                                               @RequestParam(name = "max_cost") Integer maxCost) {
        return productRepository.findAllByCostBetweenOrderByCost(minCost, maxCost);
    }

}
