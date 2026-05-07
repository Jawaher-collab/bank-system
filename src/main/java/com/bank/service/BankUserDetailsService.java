package com.bank.service;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {




        Customer customer = customerRepository
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));
        if (customer.isAccountLocked() && customer.getLockTime() != null) {
            if (customer.getLockTime().plusMinutes(30).isBefore(LocalDateTime.now())) {
                customer.setAccountLocked(false);
                customer.setFailedAttempts(0);
                customerRepository.save(customer);
            }
        }

        return new org.springframework.security.core.userdetails.User(
                customer.getUsername(),
                customer.getPassword(),
                customer.isEnabled(),
                true,
                true,
                !customer.isAccountLocked(),  // ← غيّري true لهذا
                //true,
                List.of(new SimpleGrantedAuthority(customer.getRole()))
        );
    }
}
