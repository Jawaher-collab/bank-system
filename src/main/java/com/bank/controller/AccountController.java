package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    // GET all accounts
    // localhost:8081/api/accounts
    @GetMapping
    public List<Account> getAll() {
        return accountService.findAll();
    }

    // GET account by ID
    // localhost:8081/api/accounts/1
    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    // POST create new account
    // localhost:8081/api/accounts
    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.save(account);
    }

    // DELETE account
    // localhost:8081/api/accounts/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        accountService.delete(id);
        return "Account " + id + " deleted";
    }
}
