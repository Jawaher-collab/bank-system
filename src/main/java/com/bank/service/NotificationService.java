package com.bank.service;

import com.bank.model.Notification;
import com.bank.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public Notification findById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public List<Notification> findByCustomerId(Long customerId) {
        return notificationRepository.findByCustomerId(customerId);
    }

    public List<Notification> findUnread(Long customerId) {
        return notificationRepository.findByCustomerIdAndIsRead(customerId, false);
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}
