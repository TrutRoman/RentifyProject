package com.rentify.models;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "rental_orders")
public class RentalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long managerId;
    private Long inventoryItemId;

    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;

    private String status = "ACTIVE"; // ACTIVE, COMPLETED
    private BigDecimal totalPrice;
}