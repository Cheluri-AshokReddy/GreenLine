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
public class StockDispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dispatchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime dispatchDate;

    @Lob
    private String notes;

    @OneToMany(mappedBy = "stockDispatch", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<StockProduct> stockProducts = new ArrayList<>();
}
