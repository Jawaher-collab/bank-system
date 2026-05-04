package com.bank.controller;

import com.bank.model.Transaction;
import com.bank.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    // POST transfer money
    // localhost:8083/api/transfer
    @GetMapping
    public Transaction transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam BigDecimal amount) {

        return transferService.transfer(fromId, toId, amount);
    }
}
