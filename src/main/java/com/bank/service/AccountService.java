package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
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
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
