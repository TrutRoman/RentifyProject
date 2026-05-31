package com.rentify.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String role; // CLIENT, MANAGER, TECH, ADMIN

    private Double rating = 5.0;
    private Boolean isBlocked = false;
}