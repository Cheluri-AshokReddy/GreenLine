package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.SalesSubmissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesSubmissionRepository extends JpaRepository<SalesSubmissions, Integer> {
}
