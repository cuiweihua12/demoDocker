package com.example.demo.threads;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private  long balance;


    public long deposit(long amount) {
        balance = balance + amount;
        return balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}