package com.example.GreenLine.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SalesSubmissionRequestDTO {
    private Integer userId;
    private String customerName;
    private String customerContact;
    private String deliveryAddress;
    private LocalDateTime expectedDeliveryDate;
    private List<ItemDTO> items;
}