package com.bank.service;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Get all customers
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Get customer by email
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    // Create new customer
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete customer
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
