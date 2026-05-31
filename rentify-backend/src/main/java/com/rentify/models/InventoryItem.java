package com.rentify.models;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "inventory_items")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type; // VEHICLE, EQUIPMENT

    @Column(nullable = false)
    private String status; // AVAILABLE, RENTED, IN_REPAIR, DECOMMISSIONED

    @Column(nullable = false)
    private BigDecimal pricePerHour;
}