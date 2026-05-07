package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Bean Validation
    @NotBlank(message = "First name required")
    @Size(min = 1, max = 100)
    private String firstName;

    @NotBlank(message = "Last name required")
    @Size(min = 1, max = 100)
    private String lastName;

    @NotNull(message = "Email required")
    @Email(message = "Must be a valid email")
    @Column(nullable = false, unique = true)
    private String email;

    // Set automatically on INSERT
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    private String username;

    @Column(nullable = false)
    private String password;

    private String role = "ROLE_USER";

    private boolean enabled = true;
    private int failedAttempts = 0;
    private boolean accountLocked = false;
    private LocalDateTime lockTime;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties({"customer", "hibernateLazyInitializer"})
    private List<Account> accounts = new ArrayList<>();
}
