package ru.geekbrains.spring.boot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;
}
