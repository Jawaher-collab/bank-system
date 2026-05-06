package com.bank.repository;

import com.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // كل الحسابات اللي تخص مستخدم معين
    List<Account> findByCustomer_Username(String username);

    // حساب معين بس لو يخص هذا المستخدم — يمنع IDOR
    Optional<Account> findByIdAndCustomer_Username(Long id, String username);
}
