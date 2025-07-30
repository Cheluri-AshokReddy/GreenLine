package com.example.GreenLine.DTO;

import lombok.Data;

@Data
public class StockUpdateItemDTO {
    private Integer productId;
    private Integer quantity;
    private Double mrp;
    private Double gst;
}
