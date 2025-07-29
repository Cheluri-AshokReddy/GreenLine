package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    @Query("SELECT p FROM Products p WHERE p.productId = :id")
    Optional<Products> findProductById(@Param("id") Integer id);

}
