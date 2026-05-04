package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Message content
    private String message;

    // Type: ALERT, PROMO, SECURITY, INFO
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    // false = not read, true = read
    private boolean isRead = false;

    // Set automatically on INSERT
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Many notifications belong to ONE customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"notifications", "hibernateLazyInitializer"})
    private Customer customer;
}
