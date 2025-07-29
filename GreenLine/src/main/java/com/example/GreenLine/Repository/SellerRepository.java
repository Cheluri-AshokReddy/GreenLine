package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Sellers, Integer> {
}
