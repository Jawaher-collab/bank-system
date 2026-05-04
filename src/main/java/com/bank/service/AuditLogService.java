package com.bank.service;

import com.bank.model.Account;
import com.bank.model.AuditLog;
import com.bank.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public List<AuditLog> findAll() {
        return auditLogRepository.findAll();
    }

    public AuditLog findById(Long id) {
        return auditLogRepository.findById(id).orElse(null);
    }

    public List<AuditLog> findByAccountId(Long accountId) {
        return auditLogRepository.findByAccountId(accountId);
    }

    public AuditLog save(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    public void delete(Long id) {
        auditLogRepository.deleteById(id);
    }
}

