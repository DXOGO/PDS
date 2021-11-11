//package ex1;
import java.util.Vector;

// Sweets
class Database {
    // Data elements
    private Vector<Employee> employees; // Stores the employees
        
    public Database() { employees = new Vector<>(); }
    
    public boolean addEmployee(Employee employee) {

        for (Employee emp : this.employees){ //verificar se employee já está na database
            if(emp.equals(employee)){
                System.out.println("[ERROR] Employee already in the system!");
                return false;    
            }
        }

        this.employees.add(employee);
        return true;
    }
    
    public void deleteEmployee(long emp_num) {
        
        Employee e = null;

        for (Employee emp : this.employees){
            if (emp.getEmpNum() == emp_num){
                e = emp;
                this.employees.remove(e);
                break;
            }
        }
    }
    
    public Employee[] getAllEmployees() {
        
        Employee[] all_emp = new Employee[this.employees.size()];

        for (int i = 0; i < all_emp.length; i++ ){
            all_emp[i] = employees.get(i);
        }

        return all_emp;
    }
}