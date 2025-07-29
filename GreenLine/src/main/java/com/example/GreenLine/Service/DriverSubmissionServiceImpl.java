package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.DriverSubmissionRequest;
import com.example.GreenLine.DTO.DriverSubmissionResponseDTO;
import com.example.GreenLine.Exceptions.UserNotFoundException;
import com.example.GreenLine.Model.DriverSubmissions;
import com.example.GreenLine.Model.User;
import com.example.GreenLine.Repository.DriverSubmissionRepository;
import com.example.GreenLine.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class DriverSubmissionServiceImpl implements DriverSubmissionService {


    private final DriverSubmissionRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public DriverSubmissionResponseDTO saveSubmission(DriverSubmissionRequest submission) {
        // 1. Get user by ID
        User user = userRepository.findById(submission.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with Id '" + submission.getUserId() + "' not found."));

        DriverSubmissions driverSubmission = modelMapper.map(submission, DriverSubmissions.class);

        driverSubmission.setSubmissionId(null); // Ensure it's treated as a new record


        // ✅ Set the user object (this is the important part)
        driverSubmission.setUser(user);

        // 3. Set timestamp
        driverSubmission.setCreatedAt(LocalDateTime.now());

        // 4. Save
        DriverSubmissionResponseDTO DriversubmissionresponseDTO = modelMapper.map(repository.save(driverSubmission),DriverSubmissionResponseDTO.class);
        DriversubmissionresponseDTO.setEmail(user.getEmail());
        DriversubmissionresponseDTO.setFullName(user.getFullName());
        DriversubmissionresponseDTO.setMobileNumber(user.getMobileNumber());
        return DriversubmissionresponseDTO;
    }



    @Override
    public long countTripsForToday(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        LocalDateTime start = LocalDate.now().atStartOfDay();
        LocalDateTime end = LocalDate.now().atTime(LocalTime.MAX);
        return repository.countByUserAndCreatedAtBetween(user, start, end);
    }

    @Override
    public long countTripsForWeek(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        LocalDateTime start = LocalDate.now().with(java.time.DayOfWeek.MONDAY).atStartOfDay();
        LocalDateTime end = LocalDate.now().with(java.time.DayOfWeek.SUNDAY).atTime(LocalTime.MAX);
        return repository.countByUserAndCreatedAtBetween(user, start, end);
    }

    @Override
    public long countTripsForMonth(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        LocalDate now = LocalDate.now();
        LocalDateTime start = now.withDayOfMonth(1).atStartOfDay();
        LocalDateTime end = now.withDayOfMonth(now.lengthOfMonth()).atTime(LocalTime.MAX);
        return repository.countByUserAndCreatedAtBetween(user, start, end);
    }

    @Override
    public long countTripsForYear(Integer userId, int fromYear, int toYear) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        LocalDateTime start = LocalDate.of(fromYear, 1, 1).atStartOfDay();
        LocalDateTime end = LocalDate.of(toYear, 12, 31).atTime(LocalTime.MAX);
        return repository.countByUserAndCreatedAtBetween(user, start, end);
    }


}


