package com.example.GreenLine.Controller;

import com.example.GreenLine.DTO.StockUpdateRequestDTO;
import com.example.GreenLine.Service.StockUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock-update")
@RequiredArgsConstructor
public class StockUpdateController {

    private final StockUpdateService stockUpdateService;

    @PostMapping
    public ResponseEntity<String> updateStock(@RequestBody StockUpdateRequestDTO request) {
        stockUpdateService.updateStock(request);
        return ResponseEntity.ok("Stock updated successfully");
    }
}
