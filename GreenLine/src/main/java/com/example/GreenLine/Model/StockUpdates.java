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
public class StockUpdates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer updateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Sellers seller;

    private LocalDateTime updateDate;

    @Lob
    private String notes;

    @OneToMany(mappedBy = "stockUpdate", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<StockProducts> stockProducts = new ArrayList<>();
}
