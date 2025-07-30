package com.example.GreenLine.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StockDispatchRequestDTO {
    private Integer userId;
    private String notes;
    private List<StockDispatchItemDTO> stockItems;
}
