package ru.geekbrains.eureka.client.front;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsFrontClientImpl {

    private final ProductsFrontClient productsFrontClient;

    @GetMapping
    List<ProductDto> findAll() {
        return productsFrontClient.findAllProducts();
    }

}
