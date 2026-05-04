package com.bank.repository;

import com.bank.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    // Get all notifications for a customer
    List<Notification> findByCustomerId(Long customerId);

    // Get unread notifications for a customer
    List<Notification> findByCustomerIdAndIsRead(Long customerId, boolean isRead);
}
