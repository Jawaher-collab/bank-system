package com.bank.service;

import com.bank.model.Customer;
import com.bank.model.VerificationToken;
import com.bank.repository.CustomerRepository;
import com.bank.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final CustomerRepository customerRepository;
    private final VerificationTokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

    @Transactional
    public void register(Customer customer) {
        // 1. شفّر الباسورد
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setEnabled(false);        // ما يدخل قبل التفعيل
        customer.setRole("ROLE_USER");
        customerRepository.save(customer);

        // 2. ولّد التوكن
        String token = UUID.randomUUID().toString();
        VerificationToken vt = VerificationToken.builder()
                .token(token)
                .customer(customer)
                .expiresAt(LocalDateTime.now().plusHours(24))
                .build();
        tokenRepository.save(vt);

        // 3. أرسل الإيميل
        sendVerificationEmail(customer.getEmail(), token);
    }

    public void verify(String token) {
        VerificationToken vt = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (vt.isUsed())
            throw new RuntimeException("Token already used");

        if (vt.getExpiresAt().isBefore(LocalDateTime.now()))
            throw new RuntimeException("Token expired");

        Customer customer = vt.getCustomer();
        customer.setEnabled(true);
        customerRepository.save(customer);

        vt.setUsed(true);
        tokenRepository.save(vt);

    }

    private void sendVerificationEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Verify your JD Bank account");
        message.setText("Click the link to verify your account:\n\n"
                + "http://localhost:8000/verify?token=" + token);
        mailSender.send(message);
    }
}
