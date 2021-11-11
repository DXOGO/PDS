// package io.github.jiangdequan;

/*
// Exercício 1
public class Employee extends Person {
    private double salary;

    public Employee(String n, double s) {
        super(n);
        salary = s;
    }

    public double getSalary() {
        return salary;
    }
}
*/

public class Employee {
    private double salary;    
    private Person person;
    private BankAccount bankAccount;

    public Employee(Person p, double s) {
        person = p;
        salary = s;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        if (Company.user == User.COMPANY){
            return new BankAccountProxy(bankAccount);
        }
        return bankAccount;
    }
}