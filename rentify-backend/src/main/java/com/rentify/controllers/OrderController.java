package com.rentify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentify.dto.RentalStats;
import com.rentify.models.InventoryItem;
import com.rentify.models.RentalOrder;
import com.rentify.repositories.InventoryRepository;
import com.rentify.repositories.OrderRepository;

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
        // Отримуємо ID через вкладений об'єкт інвентарю
        InventoryItem item = inventoryRepository.findById(order.getInventoryItem().getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
                
        // Змінюємо статус на "В оренді"
        item.setStatus("RENTED");
        inventoryRepository.save(item);
        
        // Прив'язуємо знайдений об'єкт майна до нашого замовлення перед збереженням
        order.setInventoryItem(item);
        
        return orderRepository.save(order);
    }

    @GetMapping("/client/{clientId}")
    public List<RentalOrder> getClientOrders(@PathVariable Long clientId) {
        return orderRepository.findByClientId(clientId);
    }

    // Метод для оформлення повернення
    @PutMapping("/{orderId}/return")
    public RentalOrder returnOrder(@PathVariable Long orderId) {
        // Знаходимо замовлення
        RentalOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Замовлення не знайдено"));

        // Змінюємо статус замовлення на Завершено
        order.setStatus("COMPLETED");

        // Змінюємо статус самого майна назад на Доступно
        InventoryItem item = order.getInventoryItem();
        if (item != null) {
            item.setStatus("AVAILABLE");
            inventoryRepository.save(item);
        }

        // Зберігаємо оновлене замовлення
        return orderRepository.save(order);
    }

    @GetMapping("/stats")
    public List<RentalStats> getStatistics() {
        return orderRepository.getRentalStatistics();
    }
}