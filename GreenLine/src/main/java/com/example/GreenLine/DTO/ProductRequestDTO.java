package com.example.GreenLine.DTO;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String productName;
    private String description;
    private String unit;
    private Double mrp;
    private Double gst;
    private Integer sellerId;
}
