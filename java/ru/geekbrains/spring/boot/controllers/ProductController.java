package ru.geekbrains.spring.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.boot.models.Product;
import ru.geekbrains.spring.boot.services.ProductService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String findAll(Model model,
                          @RequestParam(required = false, name = "min_cost") BigDecimal minCost,
                          @RequestParam(required = false, name = "max_cost") BigDecimal maxCost) {
        model.addAttribute("products",productService.findAll(minCost, maxCost));
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }

}
