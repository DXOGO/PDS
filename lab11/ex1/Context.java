import java.util.ArrayList;

public class Context {

    private SortingMethod sm;

    public void setSM(SortingMethod sm) { this.sm = sm; }

    public ArrayList<Phone> exSM(ArrayList<Phone> phones) { 
        for (Phone p : phones) { System.out.println(p);}
        System.out.println();
        return sm.sort(phones); 
    }
    
}
