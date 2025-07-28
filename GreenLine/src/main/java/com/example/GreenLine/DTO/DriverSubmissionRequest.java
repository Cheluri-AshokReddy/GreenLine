package com.example.GreenLine.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DriverSubmissionRequest {

    private Integer userId;

    private BigDecimal totalProfileAmount;

    private BigDecimal amountReceived;

    private BigDecimal balanceAmount;

    private Boolean pendingAmountFlag;

    private BigDecimal travelCharges;

    private String proofImageUrl;
}

