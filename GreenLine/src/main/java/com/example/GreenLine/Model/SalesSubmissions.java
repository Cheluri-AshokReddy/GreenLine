package com.example.GreenLine.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesSubmissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer submissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String customerName;
    private String customerContact;
    private String deliveryAddress;
    private LocalDateTime expectedDeliveryDate;
    private LocalDateTime createdAt;
    private Double totalSubmissionPrice;

    @OneToMany(mappedBy = "salesSubmission", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SalesSubmissionItems> items = new ArrayList<>();
}
