package com.simple.service;

import com.simple.domain.Wallet;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private static final Wallet wallet = new Wallet();

    public Float getBalance() {
        return wallet.getBalance();
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    public Float addMoney(float amount) {
        return wallet.add(amount);
    }

    public Float pay(float amount) {
        return wallet.pay(amount);
    }

}
