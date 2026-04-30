package com.bank.repository;

import com.bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    // Derived query - Spring generates SQL automatically
    Optional<Customer> findByEmail(String email);
}
