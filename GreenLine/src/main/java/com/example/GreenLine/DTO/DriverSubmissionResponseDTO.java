package com.example.GreenLine.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class DriverSubmissionResponseDTO {
    Integer submissionId;
    Integer userId;
    String fullName;
    String email;
    String mobileNumber;
    BigDecimal totalProfileAmount;
    BigDecimal amountReceived;
    BigDecimal balanceAmount;
    Boolean pendingAmountFlag;
    BigDecimal travelCharges;
    String proofImageUrl;
    LocalDateTime createdAt;
}
