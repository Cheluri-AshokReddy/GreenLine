package com.example.GreenLine.Controller;

import com.example.GreenLine.DTO.SalesSubmissionRequestDTO;
import com.example.GreenLine.Service.SalesSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesSubmissionController {

    private final SalesSubmissionService salesSubmissionService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitSales(@RequestBody SalesSubmissionRequestDTO request) {
        salesSubmissionService.submitSales(request);
        return ResponseEntity.ok("Sales submission successful");
    }
}

