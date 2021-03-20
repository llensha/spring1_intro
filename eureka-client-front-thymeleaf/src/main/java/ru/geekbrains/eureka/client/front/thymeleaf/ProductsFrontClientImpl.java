package ru.geekbrains.eureka.client.front.thymeleaf;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsFrontClientImpl {

    private final ProductsFrontClient productsFrontClient;

    @GetMapping
    String findAllProducts(Model model,
                         @RequestParam(required = false, name = "min_cost") BigDecimal minCost,
                         @RequestParam(required = false, name = "max_cost") BigDecimal maxCost
    ) {
        model.addAttribute("products", productsFrontClient.findAllProducts(minCost, maxCost));
        return "products";
    }

}
