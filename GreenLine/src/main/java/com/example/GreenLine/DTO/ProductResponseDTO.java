package com.example.GreenLine.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDTO {
    private Integer productId;
    private String productName;
    private String description;
    private String unit;
    private Double mrp;
    private Double gst;
    private LocalDateTime createdAt;
    private Integer sellerId;
}
