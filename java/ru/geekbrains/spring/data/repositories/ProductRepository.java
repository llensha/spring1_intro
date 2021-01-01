package ru.geekbrains.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCostIsGreaterThanEqualOrderByCost(int minCost);

    List<Product> findAllByCostIsLessThanEqualOrderByCost(int maxCost);

    List<Product> findAllByCostBetweenOrderByCost(int minCost, int maxCost);

}
