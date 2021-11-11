import java.util.ArrayList;
import java.util.List;

class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        if (!this.isEmpregado(emp.codigo())) {
            this.empregados.add(emp);
        } else {
            System.out.println("[ERROR] Employee already exists!");
        }
    }

    public void remove(int codigo) {
        
        Empregado e = null;

        for (Empregado emp : this.empregados){
            if (emp.codigo() == codigo){
                e = emp;
                this.empregados.remove(e);
                break;
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        for (Empregado e : this.empregados) {
            if (e.codigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public List<Empregado> listaDeEmpregados() {

        List<Empregado> all_emp = new ArrayList<Empregado>();
        for (Empregado e : this.empregados) { all_emp.add(e); }
        return all_emp;
    }   
}