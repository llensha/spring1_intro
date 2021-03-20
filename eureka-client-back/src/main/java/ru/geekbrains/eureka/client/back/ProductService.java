package ru.geekbrains.eureka.client.back;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public List<ProductDto> findAll(BigDecimal minCost, BigDecimal maxCost) {
        List<ProductDto> out = findAll();
        if (minCost != null) {
            out = out.stream().filter(p -> p.getCost().compareTo(minCost) >= 0).collect(Collectors.toList());
        }
        if (maxCost != null) {
            out = out.stream().filter(p -> p.getCost().compareTo(maxCost) <= 0).collect(Collectors.toList());
        }
        return out;
    }

}
