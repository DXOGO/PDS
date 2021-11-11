import java.util.Iterator;
import java.util.ListIterator;

public class ex1 {

    public static void main(String[] args) {
        
        VectorGeneric<Integer> vec = new VectorGeneric<>(); // creating generiic vector
        
        for (int i = 0; i < 20; i++){ vec.addElem(i); } // adding elements

        // Normal iterator 
        System.out.println("Iterating with normal iterator...");
         
        Iterator<Integer> normalIterator = vec.Iterator();
        while (normalIterator.hasNext()) { System.out.println(normalIterator.next()); }

        
        //--------------------------------------------------------------------------------
        // List iterator (index = 0)
        System.out.println("\n\nIterating with list iterator (index = 0)...");

        ListIterator<Integer> listIterator = vec.listIterator();

        // using next (going forward)
        System.out.println("\n[Going Forward]");
        while (listIterator.hasNext()) {
            System.out.printf("Index %d: %d\n",listIterator.nextIndex(), listIterator.next());
        }
        
        // using previous (going backwards)
        System.out.println("\n[Going Backward]");
        while (listIterator.hasPrevious()) {
            System.out.printf("Index %d: %d\n",listIterator.previousIndex()+1, listIterator.previous());
        }

        
        //--------------------------------------------------------------------------------
        // List iterator 2(index != 0)
        System.out.println("\n\nIterating with list iterator 2 (index != 0)...");

        ListIterator<Integer> listIterator2 = vec.listIterator(10);

        // using next (going forward)
        System.out.println("\n[Going Forward]");
        while (listIterator2.hasNext()) {
            System.out.printf("Index %d: %d\n",listIterator2.nextIndex(), listIterator2.next());
        }
        
        // using previous (going backwards)
        System.out.println("\n[Going Backward]");
        while (listIterator2.hasPrevious()) {
            System.out.printf("Index %d: %d\n",listIterator2.previousIndex()+1, listIterator2.previous());
        }
    }
}
