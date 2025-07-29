package com.example.GreenLine.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_id")
    private StockUpdates stockUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispatch_id")
    private StockDispatchs stockDispatch;

    private Integer quantity;
    private Double mrp;
    private Double gst;
}