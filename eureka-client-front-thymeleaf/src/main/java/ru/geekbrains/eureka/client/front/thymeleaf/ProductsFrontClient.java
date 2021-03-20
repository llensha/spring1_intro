package ru.geekbrains.eureka.client.front.thymeleaf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient("eureka-client-back")
public interface ProductsFrontClient {

    @GetMapping("/products")
    List<ProductDto> findAllProducts(
                           @RequestParam(required = false, name = "min_cost") BigDecimal minCost,
                           @RequestParam(required = false, name = "max_cost") BigDecimal maxCost
    );

}
