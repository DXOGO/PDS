import java.util.Date;

abstract class EmployeeDecorator implements EmployeeInterface {

    protected EmployeeInterface emp;

    EmployeeDecorator(EmployeeInterface e){
        this.emp = e;
    }

    public String getName(){ return this.emp.getName(); }

    @Override
    public void start(Date d){ this.emp.start(d); }

    @Override
    public void terminate(Date d){ this.emp.terminate(d);}

    @Override 
    public void work(){ this.emp.work(); }


}
