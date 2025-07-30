package com.example.GreenLine.Controller;

import com.example.GreenLine.DTO.StockDispatchRequestDTO;
import com.example.GreenLine.Service.StockDispatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock/dispatch")
@RequiredArgsConstructor
public class StockDispatchController {

    private final StockDispatchService stockDispatchService;

    @PostMapping
    public ResponseEntity<String> dispatchStock(@RequestBody StockDispatchRequestDTO request) {
        try {
            stockDispatchService.dispatchStock(request);
            return ResponseEntity.ok("Stock dispatched successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Failed to dispatch stock: " + e.getMessage());
        }
    }
}
