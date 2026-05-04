package com.bank.service;

import com.bank.model.Payee;
import com.bank.repository.PayeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayeeService {

    private final PayeeRepository payeeRepository;

    public List<Payee> findAll() {
        return payeeRepository.findAll();
    }

    public Payee findById(Long id) {
        return payeeRepository.findById(id).orElse(null);
    }

    public List<Payee> findByCustomerId(Long customerId) {
        return payeeRepository.findByCustomerId(customerId);
    }

    public Payee save(Payee payee) {
        return payeeRepository.save(payee);
    }

    public void delete(Long id) {
        payeeRepository.deleteById(id);
    }

}
