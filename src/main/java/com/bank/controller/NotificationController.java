package com.bank.controller;

import com.bank.model.Notification;
import com.bank.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // GET all notifications
    // localhost:8083/api/notifications
    @GetMapping
    public List<Notification> getAll() {
        return notificationService.findAll();
    }

    // GET notification by ID
    // localhost:8083/api/notifications/1
    @GetMapping("/{id}")
    public Notification getById(@PathVariable Long id) {
        return notificationService.findById(id);
    }

    // GET notifications by customer
    // localhost:8083/api/notifications/customer/1
    @GetMapping("/customer/{customerId}")
    public List<Notification> getByCustomer(@PathVariable Long customerId) {
        return notificationService.findByCustomerId(customerId);
    }

    // POST create notification
    // localhost:8083/api/notifications
    @PostMapping
    public Notification create(@Valid @RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    // DELETE notification
    // localhost:8083/api/notifications/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        notificationService.delete(id);
        return "Notification " + id + " deleted";
    }
}
