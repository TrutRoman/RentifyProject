package com.rentify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*") 
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Цей метод приймає запит з фронтенду і пересилає його у WebSocket-канал
    @PostMapping("/send")
    public void sendNotification(@RequestBody Map<String, String> payload) {
        String topic = payload.get("topic"); // наприклад: "/topic/tech"
        String message = payload.get("message");
        messagingTemplate.convertAndSend(topic, message);
    }
}