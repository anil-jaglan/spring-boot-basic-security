package com.simple.controller;

import com.simple.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public Float getBalance() {

        return walletService.getBalance();

    }

    @GetMapping(value = "/{amount}")
    public Float addMoney(@PathVariable("amount") float amount) {

        return walletService.addMoney(amount);

    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping(value = "/pay/{amount}")
    public Float pay(@PathVariable("amount") float amount) {

        return walletService.pay(amount);

    }
}
