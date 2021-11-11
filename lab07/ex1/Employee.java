import java.util.Date;

class Employee implements EmployeeInterface{

    private String name;

    Employee(String name){ this.name = name; }

    public String getName(){ return this.name; }

    @Override
    public void start(Date d){
        System.out.println("Employee " + this.name + " started working on " + d.toString());
    }

    @Override
    public void terminate(Date d){
        System.out.println("Employee " + this.name + " stopped working on " + d.toString());
    }

    @Override 
    public void work(){
        System.out.println("Employee " + this.name + " currently works here");
    }

}