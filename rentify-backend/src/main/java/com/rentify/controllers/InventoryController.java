package com.rentify.controllers;

import com.rentify.models.InventoryItem;
import com.rentify.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/available")
    public List<InventoryItem> getAvailableItems() {
        return inventoryRepository.findByStatus("AVAILABLE");
    }

    @PostMapping("/add")
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryRepository.save(item);
    }
}