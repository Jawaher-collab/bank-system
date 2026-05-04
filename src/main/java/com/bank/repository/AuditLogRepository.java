package com.bank.repository;

import com.bank.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditLogRepository
        extends JpaRepository<AuditLog, Long> {

    // Get all audit logs for an account
    List<AuditLog> findByAccountId(Long accountId);
}
