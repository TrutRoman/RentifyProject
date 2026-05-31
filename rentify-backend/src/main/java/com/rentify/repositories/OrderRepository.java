package com.rentify.repositories;

import com.rentify.models.RentalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<RentalOrder, Long> {
}