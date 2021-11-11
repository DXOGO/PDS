import java.util.Calendar;
import java.util.Date;

public class ex1 {
    
    public static void main(String[] args) {

        EmployeeInterface dx = new Employee("Leitono");
        dx.start(new Date());
        dx.work();
        dx.terminate(new Date());

        System.out.println();
    
        TeamMember tm = new TeamMember(new Employee("Reyes"));
        tm.start(new Date());
        tm.colaborate();

        TeamLeader tl = new TeamLeader(new Employee("Enfurecido"));
        tl.start(new Date());
        tl.plan();

        System.out.println();

        Manager m = new Manager(new Employee("Martinez"));
        m.start(new Date());
        m.manage();
        m.work();
        m.terminate(new Date());
        System.out.println("He was fired for cocaine traffic...");
    }
}
