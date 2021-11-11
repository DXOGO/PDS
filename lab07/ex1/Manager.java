class Manager extends EmployeeDecorator {   // start, terminate, work, *manage* 
    
    Manager (EmployeeInterface emp) { super(emp); }

    //@Override
    public void manage(){ System.out.println(super.getName() + " is a manager!"); }
}
