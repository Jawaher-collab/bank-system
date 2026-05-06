//package com.bank.controller;
//
//import com.bank.service.CustomerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class CustomerViewController {
//
//    private final CustomerService customerService;
//
//    @GetMapping("/customers")
//    public String customers(Model model) {
//        model.addAttribute("customers", customerService.findAll());
//        return "customers"; // <- اسم الـ HTML file
//    }
//}

package com.bank.controller;

import com.bank.model.Customer;
import com.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CustomerViewController {

    private final CustomerService customerService;

    // Show all customers
    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }

    // Show add customer form
    @GetMapping("/customers/add")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    // Save new customer
    @PostMapping("/customers/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
}
