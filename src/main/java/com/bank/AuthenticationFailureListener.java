package com.bank;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AuthenticationFailureListener
        implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final CustomerRepository customerRepository;
    private static final int MAX_ATTEMPTS = 5;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String username = event.getAuthentication().getName();

        customerRepository.findByUsername(username).ifPresent(customer -> {
            customer.setFailedAttempts(customer.getFailedAttempts() + 1);

            if (customer.getFailedAttempts() >= MAX_ATTEMPTS) {
                customer.setAccountLocked(true);
                customer.setLockTime(LocalDateTime.now());
            }

            customerRepository.save(customer);
        });
    }
}
