package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.DriverSubmissionRequest;
import com.example.GreenLine.DTO.DriverSubmissionResponseDTO;
import com.example.GreenLine.Model.DriverSubmission;

public interface DriverSubmissionService {

    DriverSubmissionResponseDTO saveSubmission(DriverSubmissionRequest submission);

    long countTripsForToday(Integer userId);
    long countTripsForWeek(Integer userId);
    long countTripsForMonth(Integer userId);
    long countTripsForYear(Integer userId, int fromYear, int toYear);
}
