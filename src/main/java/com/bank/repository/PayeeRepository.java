package com.bank.repository;

import com.bank.model.Payee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayeeRepository
        extends JpaRepository<Payee, Long> {

    // Get all payees for a customer
    List<Payee> findByCustomerId(Long customerId);

    // Check if payee exists for customer
    boolean existsByCustomerIdAndAccountNumber(
            Long customerId, String accountNumber);
}
