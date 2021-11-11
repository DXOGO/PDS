import java.io.IOException;
import java.util.ArrayList;

// package pds_2021_111.lab01;

public class WSGenerator {
    public static void main(String[] args) throws IOException {
        String in_file = "";
        String out_file = "";
        int size = 0;
        // 2 parametros obrigatorios -> -i e -s
        if (args.length < 4) {
            System.err.println("Too few arguments");
            System.exit(1);
        }
        else if (args.length > 6) {
            System.err.println("Too many arguments");
            System.exit(1);
        }

        boolean i_option = false;
        boolean s_option = false;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    i_option = true;
                    if (!args[i+1].contains(".txt")) {
                        System.err.println("Input file must be .txt");
                        System.exit(1);
                    }
                    in_file = args[++i];
                    break;
                case "-s":
                    s_option = true;
                    if (!args[i+1].matches("[0-9]+")) {
                        System.err.println("Size of Word Soup must be a number");
                        System.exit(1);
                    }
                    size = Integer.parseInt(args[++i]);
                    break;
                case "-o":
                    if (!args[i+1].contains(".txt")) {
                        System.err.println("Output file must be .txt");
                        System.exit(1);
                    }
                    out_file = args[++i];
                    break;
                default:
                    System.err.println("Unknown option: " + args[i]);
                    System.exit(1);
            }
        }
        
        if (!i_option || !s_option) {
            System.out.println("-i and -s parameters are compulsory");
        }

        Generator generator = new Generator();
        if (generator.readFile(in_file)) {
            ArrayList<String> s = generator.createWS(size);

            
            if (!out_file.isEmpty()){
                generator.printSolution(s, out_file, in_file, size);   // escrever no ficheiro
            } else {   
                System.out.println(generator.createOutput(s, in_file, size));  // dar print na consola
            }
        }
    }
}
