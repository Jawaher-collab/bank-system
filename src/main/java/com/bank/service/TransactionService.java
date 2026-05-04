package com.bank.service;

import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    // Get all transactions
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    // Get transaction by ID
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    // Save transaction
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Delete transaction
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
