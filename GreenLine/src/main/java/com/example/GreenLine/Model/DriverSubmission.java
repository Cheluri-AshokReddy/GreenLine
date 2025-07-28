package com.example.GreenLine.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "driver_submissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Integer submissionId;


    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "mobile_number", length = 15, nullable = false)
    private String mobileNumber;

    @Column(name = "total_profile_amount", nullable = false)
    private BigDecimal totalProfileAmount;

    @Column(name = "amount_received", nullable = false)
    private BigDecimal amountReceived;

    @Column(name = "balance_amount", nullable = false)
    private BigDecimal balanceAmount;

    @Column(name = "pending_amount_flag", nullable = false)
    private Boolean pendingAmountFlag;

    @Column(name = "travel_charges", nullable = false)
    private BigDecimal travelCharges;

    @Column(name = "proof_image_url", length = 255)
    private String proofImageUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

