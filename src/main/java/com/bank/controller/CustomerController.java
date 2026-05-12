package com.bank.controller;

import com.bank.dto.CustomerDto;
import com.bank.model.Customer;
import com.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // GET all customers
    // localhost:8083/api/customers
    @GetMapping
    public List<CustomerDto> getAll() {
        return customerService.findAll()
                .stream()
                .map(c -> {
                    CustomerDto dto = new CustomerDto();
                    dto.setId(c.getId());
                    dto.setFirstName(c.getFirstName());
                    dto.setLastName(c.getLastName());
                    dto.setEmail(c.getEmail());
                    dto.setUsername(c.getUsername());
                    dto.setRole(c.getRole());
                    return dto;
                })
                .toList();
    }


    // GET customer by ID
    // localhost:8083/api/customers/1
    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    // POST create new customer
    // localhost:8083/api/customers
    @PostMapping
    public Customer create(@Valid @RequestBody Customer customer) {
        return customerService.save(customer);
    }

    // DELETE customer
    // localhost:8083/api/customers/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        customerService.delete(id);
        return "Customer " + id + " deleted";
    }
}
