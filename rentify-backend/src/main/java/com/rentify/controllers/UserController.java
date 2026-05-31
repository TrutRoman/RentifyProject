package com.rentify.controllers;

import com.rentify.models.User;
import com.rentify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerClient(@RequestBody User user) {
        user.setRole("CLIENT");
        return userRepository.save(user);
    }

    @GetMapping("/clients")
    public List<User> getAllClients() {
        return userRepository.findAll().stream()
                .filter(u -> "CLIENT".equals(u.getRole()))
                .toList();
    }
}