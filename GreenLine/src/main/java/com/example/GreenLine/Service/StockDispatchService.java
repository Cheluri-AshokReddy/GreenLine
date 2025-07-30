package com.example.GreenLine.Service;

import com.example.GreenLine.DTO.StockDispatchRequestDTO;

public interface StockDispatchService {
    void dispatchStock(StockDispatchRequestDTO request);
}
