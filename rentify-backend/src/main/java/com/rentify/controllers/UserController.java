package com.rentify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentify.models.User;
import com.rentify.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerClient(@RequestBody User user) {
        user.setRole("CLIENT");
        
        // ДОДАЄМО ЦЕ: Якщо менеджер не ввів пароль, ставимо тимчасовий
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword("1234"); 
        }
        
        return userRepository.save(user);
    }

    @GetMapping("/clients")
    public List<User> getAllClients() {
        return userRepository.findAll().stream()
                .filter(u -> "CLIENT".equals(u.getRole()))
                .toList();
    }
}