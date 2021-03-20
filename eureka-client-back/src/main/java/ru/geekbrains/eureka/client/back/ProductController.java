package ru.geekbrains.eureka.client.back;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> findAll(
                          @RequestParam(required = false, name = "min_cost") BigDecimal minCost,
                          @RequestParam(required = false, name = "max_cost") BigDecimal maxCost) {
        return productService.findAll(minCost, maxCost);
    }

}
