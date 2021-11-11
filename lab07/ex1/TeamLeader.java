class TeamLeader extends EmployeeDecorator {    // start, terminate, work, *plan*
 
    TeamLeader (EmployeeInterface emp) { super(emp); }

    //@Override
    public void plan(){ System.out.println(super.getName() + " is a team leader!"); }
}
