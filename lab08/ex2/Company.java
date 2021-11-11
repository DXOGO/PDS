// package io.github.jiangdequan;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();

    // alínea a)
    /*public void admitPerson(String name, double salary) {
        Employee e = new Employee(name, salary);
        emps.add(e);
    }*/

    // alínea b)
    /*public void admitEmployee(Person p, double salary) {
        Employee e = new Employee(p, salary);
        emps.add(e);
    }*/

    public void admitEmployee(Employee e) {
        emps.add(e);
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}