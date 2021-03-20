package ru.geekbrains.eureka.client.front;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("eureka-client-back")
public interface ProductsFrontClient {

    @GetMapping("/products")
    List<ProductDto> findAllProducts();

}
