package com.example.GreenLine.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StockUpdateRequestDTO {
    private Integer userId;
    private Integer sellerId;
    private String notes;
    private List<StockUpdateItemDTO> stockItems;
}
