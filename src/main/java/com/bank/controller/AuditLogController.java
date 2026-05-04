package com.bank.controller;

import com.bank.model.AuditLog;
import com.bank.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> getAll() {
        return auditLogService.findAll();
    }

    @GetMapping("/{id}")
    public AuditLog getById(@PathVariable Long id) {
        return auditLogService.findById(id);
    }

    @GetMapping("/account/{accountId}")
    public List<AuditLog> getByAccount(@PathVariable Long accountId) {
        return auditLogService.findByAccountId(accountId);
    }

    @PostMapping
    public AuditLog create(@RequestBody AuditLog auditLog) {
        return auditLogService.save(auditLog);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        auditLogService.delete(id);
        return "AuditLog " + id + " deleted";
    }
}
