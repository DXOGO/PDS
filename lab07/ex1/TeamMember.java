class TeamMember extends EmployeeDecorator { // start, terminate, work, *colaborate*
    
    TeamMember(EmployeeInterface emp) { super(emp); }

    //@Override
    public void colaborate(){ System.out.println(super.getName() + " is a team member!"); }
}
