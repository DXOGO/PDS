//package pds_2021_111.lab01;

// import java.util.Scanner;
import java.util.HashMap;

public class WSSolver {
    public static void main(String[] args) {
        //perguntar o nome do ficheiro
        
        if(args.length > 0 && args[0].contains(".txt")) {
            Solver solver = new Solver();
            if (solver.readFile(args[0])) {
                HashMap<String, Solution> solution = solver.solve();
                solver.printSolution(solution, "out1.txt");
            }
        }
        else {
            System.out.println("Error: you need to pass a .txt file as parameter");
        }
    }
}
