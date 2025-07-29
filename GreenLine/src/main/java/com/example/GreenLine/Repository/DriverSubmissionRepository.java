package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.DriverSubmissions;
import com.example.GreenLine.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DriverSubmissionRepository extends JpaRepository<DriverSubmissions, Integer> {

    long countByUserAndCreatedAtBetween(User user, LocalDateTime start, LocalDateTime end);


    List<DriverSubmissions> findByUser_UserIdAndCreatedAtBetween(Integer userId, LocalDateTime start, LocalDateTime end);


}
