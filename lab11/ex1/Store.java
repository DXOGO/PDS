import java.util.ArrayList;

public class Store {
    
    public static void main(String[] args) {
        
        // algoritmos de ordenação não implementados (!)
        
        Context con = new Context();

        ArrayList<Phone> allPhones = new ArrayList<>();
        allPhones.add(new Phone("iPhone", "X", 499.99, 12.0, 64));
        allPhones.add(new Phone("Smasung", "Galaxy S21", 649.99, 40.0, 128));
        allPhones.add(new Phone("Xiaomi", "Mi 11", 764.99, 108.0, 256));

        con.setSM(new BubbleSort());
        System.out.println("Sorted by BubbleSort:");
        con.exSM(allPhones);

        con.setSM(new QuickSort());
        System.out.println("\nSorted by QuickSort:");
        con.exSM(allPhones);

        con.setSM(new SelectionSort());
        System.out.println("\nSorted by SelectionSort:");
        con.exSM(allPhones);

    }
}
