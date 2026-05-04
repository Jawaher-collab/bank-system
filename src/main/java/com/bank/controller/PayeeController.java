package com.bank.controller;

import com.bank.model.Payee;
import com.bank.service.PayeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payees")
@RequiredArgsConstructor
public class PayeeController {

    private final PayeeService payeeService;

    @GetMapping
    public List<Payee> getAll() {
        return payeeService.findAll();
    }

    @GetMapping("/{id}")
    public Payee getById(@PathVariable Long id) {
        return payeeService.findById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Payee> getByCustomer(@PathVariable Long customerId) {
        return payeeService.findByCustomerId(customerId);
    }

    @PostMapping
    public Payee create(@Valid @RequestBody Payee payee) {
        return payeeService.save(payee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        payeeService.delete(id);
        return "Payee " + id + " deleted";
    }
}
