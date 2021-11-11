// package io.github.jiangdequan;

public class CompanyFacade {
    private Company company;
    private Insurance insurance;
    private SocialSecurity socialsecurity;
    private Parking parking;

    CompanyFacade() {
        company = new Company();
        insurance = new Insurance();
        socialsecurity = new SocialSecurity();
        parking = new Parking();
    }

    public void admitEmployee(Person p, double salary) {
        EmployeeCard card = new EmployeeCard(p.getName());
        Employee e = new Employee(p, salary, card);
        this.company.admitEmployee(e);
        this.insurance.regist(e);
        this.socialsecurity.regist(e);
        
        if (this.parking.allow(e, this.company)) {
            System.out.println("This employee may use the parking lot");
        }
        else {
            System.out.println("This employee may not use the parking lot");
        }
    }
}