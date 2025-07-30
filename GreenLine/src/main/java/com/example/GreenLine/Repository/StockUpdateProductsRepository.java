// StockUpdateProductsRepository.java
package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.StockUpdateProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockUpdateProductsRepository extends JpaRepository<StockUpdateProducts, Integer> {
    Optional<StockUpdateProducts> findByProduct_ProductId(Integer productId);
}
