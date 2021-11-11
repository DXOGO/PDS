public class ex1 {
    public static void main(String[] args) {
        
        Database db = new Database();
        RegistosDb Staff = new RegistosDb(db);


        // criar empregados da Sweets   
        Employee se1 = new Employee("Marx", 55, 1000.50);
        Employee se2 = new Employee("Russel", 56, 800.25);
        Employee se3 = new Employee("Tyler", 57, 700.00);

        // adicionar empregados da Sweets 
        Staff.insere(se1);
        Staff.insere(se2);
        Staff.insere(se3);

        // criar empregados do Petiscos
        Empregado pe1 = new Empregado("Phineas", "Flower", 8, 1200.00);
        Empregado pe2 = new Empregado("Ferb", "Febras", 9, 499.99); 
        
        // adicionar empregados do Petiscos
        Staff.insere(pe1);
        Staff.insere(pe2);

        //New Company
        System.out.println("Current Staff:");
        Staff.printEmployees();

        Staff.remove(57);
        Staff.remove(8);
        System.out.println("\nNew current Staff without Tyler and Phineas because they were fired:");
        Staff.printEmployees();

        System.out.println("\nIs there a worker with code 0 in the company? " + Staff.isEmpregado(0) );
        System.out.println("Is Ferb a worker in the company? " + Staff.isEmpregado(pe2.codigo()));

        Empregado pe3 = new Empregado("Baljeet", "Ranjit", 420, 9999999.99);
        Staff.insere(pe3);
        System.out.println("\n" + pe3.nome() + " has joined the company with a modest $" + pe3.salario() + " sallary!");
        

    }
}
