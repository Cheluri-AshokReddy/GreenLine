package com.example.GreenLine.Repository;

import com.example.GreenLine.Model.DriverSubmission;
import com.example.GreenLine.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DriverSubmissionRepository extends JpaRepository<DriverSubmission, Integer> {

    // Count trips per driver in a date range


    // Correct version using the User object reference
    long countByUserAndCreatedAtBetween(User user, LocalDateTime start, LocalDateTime end);


    List<DriverSubmission> findByUser_UserIdAndCreatedAtBetween(Integer userId, LocalDateTime start, LocalDateTime end);


}
