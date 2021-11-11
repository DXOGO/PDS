// package io.github.jiangdequan;

public class BankAccountProxy implements BankAccount {
    BankAccount account;

    BankAccountProxy(BankAccount account) {
        this.account = account;
    }

    @Override public void deposit(double amount) {
        this.account.deposit(amount);
    }

    @Override public boolean withdraw(double amount) {
        System.out.println("[ERROR] You do not have access to this account.");
        return false;
    }

    @Override public double balance() {        
        System.out.println("[ERROR] You do not have access to this account.");
        return 0;
    }
}