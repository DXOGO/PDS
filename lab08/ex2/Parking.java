// package io.github.jiangdequan;

import java.util.List;
import java.util.ArrayList;

public class Parking {
    private List<Employee> allowed = new ArrayList<>();

    public boolean allow(Employee person, Company comp){
        List<Employee> emps = comp.employees();

        int sum = 0;
        for (Employee e : emps) {
            sum += e.getSalary();
        }

        if (sum / emps.size() < person.getSalary()) {
            allowed.add(person);
            return true;
        }
        return false;
    }
}