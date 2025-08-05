package com.example.GreenLine.Controller;

import com.example.GreenLine.DTO.SalesSubmissionRequestDTO;
import com.example.GreenLine.Service.SalesSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesSubmissionController {

    private final SalesSubmissionService salesSubmissionService;

    @PostMapping("/submit")
    public ResponseEntity<Double> submitSales(@RequestBody SalesSubmissionRequestDTO request) {

        return new ResponseEntity<>(salesSubmissionService.submitSales(request), HttpStatus.CREATED);
    }
}

