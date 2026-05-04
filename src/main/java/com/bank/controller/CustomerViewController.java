package com.bank.controller;

import com.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CustomerViewController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers"; // <- اسم الـ HTML file
    }
}
