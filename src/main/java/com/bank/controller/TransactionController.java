package com.bank.controller;

import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.service.CustomerService;
import com.bank.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    @RequestMapping("/api/transactions")
    @RequiredArgsConstructor
    public class TransactionController {

        private final TransactionService transactionService;

        // GET all customers
        // localhost:8083/api/customers
        @GetMapping
        public List<Transaction> getAll() {
            return transactionService.findAll();
        }

        // GET customer by ID
        // localhost:8083/api/customers/1
        @GetMapping("/{id}")
        public Transaction getById(@PathVariable Long id) {
            return transactionService.findById(id);
        }

        // POST create new customer
        // localhost:8083/api/customers
        @PostMapping
        public  Transaction create (@Valid @RequestBody Transaction transaction) {
            return transactionService.save(transaction);
        }

        // DELETE customer
        // localhost:8083/api/customers/1
        @DeleteMapping("/{id}")
        public String delete(@PathVariable Long id) {
            transactionService.delete(id);
            return "Transaction " + id + " deleted";
        }
    }


