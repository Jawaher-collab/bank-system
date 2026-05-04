package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.TransactionType;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public Transaction transfer(Long fromId, Long toId, BigDecimal amount) {

        // Get both accounts
        Account from = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Account not found: " + fromId));

        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Account not found: " + toId));

        // Check balance
        if (from.getBalance() < amount.doubleValue()) {
            throw new RuntimeException("Insufficient funds");
        }

        // Deduct from sender
        from.setBalance(from.getBalance() - amount.doubleValue());

        // Add to receiver
        to.setBalance(to.getBalance() + amount.doubleValue());

        // Save transaction record
        Transaction transaction = Transaction.builder()
                .fromAccount(from)
                .toAccount(to)
                .type(TransactionType.TRANSFER)
                .amount(amount)
                .build();

        return transactionRepository.save(transaction);
    }


}
