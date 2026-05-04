package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "payees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Payee {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Payee name e.g. "Con Edison"
    @NotBlank
    private String payeeName;

    // Bank name e.g. "Chase Bank"
    private String bankName;

    // External account number
    private String accountNumber;

    // Many payees belong to ONE customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"payees", "hibernateLazyInitializer"})
    private Customer customer;
}
