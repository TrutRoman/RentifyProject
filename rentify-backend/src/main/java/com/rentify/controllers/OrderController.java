package com.rentify.controllers;

import com.rentify.models.RentalOrder;
import com.rentify.models.InventoryItem;
import com.rentify.repositories.OrderRepository;
import com.rentify.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/create")
    public RentalOrder createOrder(@RequestBody RentalOrder order) {
        InventoryItem item = inventoryRepository.findById(order.getInventoryItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setStatus("RENTED");
        inventoryRepository.save(item);
        return orderRepository.save(order);
    }
}