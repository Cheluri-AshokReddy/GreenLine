package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.SalesSubmissionItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesSubmissionItemRepository extends JpaRepository<SalesSubmissionItems, Integer> {
}
