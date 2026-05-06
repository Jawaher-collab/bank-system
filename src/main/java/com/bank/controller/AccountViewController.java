package com.bank.controller;

import com.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AccountViewController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public String myAccounts(@AuthenticationPrincipal UserDetails user,
                             Model model) {
        model.addAttribute("accounts",
                accountService.getMyAccounts(user.getUsername()));
        return "accounts";
    }
}
