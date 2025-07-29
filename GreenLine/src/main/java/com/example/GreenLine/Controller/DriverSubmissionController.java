package com.example.GreenLine.Controller;


import com.example.GreenLine.DTO.DriverSubmissionRequest;
import com.example.GreenLine.DTO.DriverSubmissionResponseDTO;
import com.example.GreenLine.Service.DriverSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/driver-submissions")
public class DriverSubmissionController {

    @Autowired
    private DriverSubmissionService driverSubmissionService;

    // Save a new driver submission
    @PostMapping
    public DriverSubmissionResponseDTO createSubmission(@RequestBody DriverSubmissionRequest submission) {
        return driverSubmissionService.saveSubmission(submission);
    }

    // Count trips for today
    @GetMapping("/count/today/{userId}")
    public long getTodayTripCount(@PathVariable Integer userId) {
        return driverSubmissionService.countTripsForToday(userId);
    }

    // Count trips for the current week
    @GetMapping("/count/week/{userId}")
    public long getWeekTripCount(@PathVariable Integer userId) {
        return driverSubmissionService.countTripsForWeek(userId);
    }

    // Count trips for the current month
    @GetMapping("/count/month/{userId}")
    public long getMonthTripCount(@PathVariable Integer userId) {
        return driverSubmissionService.countTripsForMonth(userId);
    }

    // Count trips between years
    @GetMapping("/count/year/{userId}")
    public long getYearTripCount(@PathVariable Integer userId,
                                 @RequestParam int fromYear,
                                 @RequestParam int toYear) {
        return driverSubmissionService.countTripsForYear(userId, fromYear, toYear);
    }
}
