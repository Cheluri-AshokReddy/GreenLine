package com.example.GreenLine.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "stock_update_products")
public class StockUpdateProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_id", nullable = false)
    private StockUpdates stockUpdate;

    private Integer quantity;
    private Double mrp;
    private Double gst;
}
