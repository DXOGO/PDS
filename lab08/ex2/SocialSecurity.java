// package io.github.jiangdequan;

import java.util.List;
import java.util.ArrayList;

public class SocialSecurity {
    private List<Employee> registered = new ArrayList<>();

    public void regist(Employee person) {
        registered.add(person);
    }
}