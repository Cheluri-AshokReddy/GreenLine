package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.StockUpdates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockUpdateRepository extends JpaRepository<StockUpdates, Integer> {
}
