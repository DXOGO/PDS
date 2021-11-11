public class RegistosDb extends Registos {
    Database db;

    // public RegistosDb() {
    //     this.db = new Database();
    // }

    public RegistosDb(Database db) {
        super();

        if (db == null) {
            throw new IllegalArgumentException("Database cannot be null!");
        }
        this.db = db;
    }

    public void remove(int codigo) {
        db.deleteEmployee(codigo);

        if (super.isEmpregado(codigo)) {
            super.remove(codigo);
        }
    }

    public void insere(Empregado emp) {
        super.insere(emp);
    }

    public boolean insere(Employee emp) {
        return this.db.addEmployee(emp);
    }

    // public List<Empregado> listaDeEmpregados() {
    //     Employee[] emps = db.getAllEmployees();

    //     for (Employee emp : emps) {
    //         Empregado e = new Empregado(e.getName(), "", e.getEmpNum(), e.getSalary());
    //         super.insere(e);
    //     }

    //     return super.empregados;
    // }

    public void printEmployees(){

        for(Employee i : this.db.getAllEmployees()){
            System.out.println("Name: " + i.getName() + ", Number: " + i.getEmpNum());
        } 

        for(Empregado i : super.listaDeEmpregados()){
            System.out.println("Name: " + i.nome() + " " + i.apelido() + ", Number: " + i.codigo());
        } 
    }

}
