package com.bank.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
//import java.time.LocalDateTime;



    @Entity
    @Table(name = "transaction")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)

    public class Transaction {
        @EqualsAndHashCode.Include
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "to account_id")
        private Account toAccount;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "from account_id")
        private Account fromAccount;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TransactionType type;

        @Column(nullable = false, precision = 15, scale = 2)
        private BigDecimal amount;

        @CreationTimestamp
        private LocalDateTime transactionDate;


}
