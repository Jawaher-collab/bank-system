package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
    public Account save(Account account) {
        return accountRepository.save(account);
    }
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
    //حسابات المستخدم الحالي
    public List<Account> getMyAccounts(String username) {
        return accountRepository.findByCustomer_Username(username);
    }
    // حساب معين — بس لو يخص هذا المستخدم
    public Account getAccountById(Long id, String username) {
        return accountRepository
                .findByIdAndCustomer_Username(id, username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}

