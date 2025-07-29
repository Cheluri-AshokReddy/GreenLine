package com.example.GreenLine.DTO;

import lombok.Data;

@Data
public class ItemDTO {
    private Integer productId;
    private Integer quantity;
    private Double mrp;
    private Double gst;
}
