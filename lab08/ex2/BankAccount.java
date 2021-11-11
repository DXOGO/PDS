// package io.github.jiangdequan;

public interface BankAccount {
    void deposit(double amount);
    boolean withdraw(double amount);
    double balance();
}