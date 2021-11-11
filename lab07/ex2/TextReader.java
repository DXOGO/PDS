import java.util.Scanner;
import java.io.File;

public class TextReader implements TextReaderInterface{
    private File file;
    private int actualParagraph;
    private boolean reset = false; // se chegar ao fim do ficheiro tem de dar reset ou então o user pode querer dar

    public TextReader(String filePath) {
        try {
            this.file = new File(filePath);
            this.actualParagraph = 0;
        } catch (Exception e) {
            this.file = null;
            this.actualParagraph = 0;
            System.out.println("[ERROR] The file was not found, it was set to null.");
        }
    }

    public void resetReader() {
        this.reset = !this.reset;
    }

    public int getActualParagraph() {
        return this.actualParagraph;
    }

    public boolean hasNext(){
        if (this.file == null) {
            System.out.println("[ERROR] The file is null, please set it using setFile(fileName).");
            return false;
        }

        try {            
            Scanner sc = new Scanner(file);

            if (this.reset) { // se for para fazer reset temos de o fazer antes de ver se tem próximo
                this.actualParagraph = 0;
            }

            for (int i = 0; i < this.actualParagraph; i++) {
                // ler até onde estamos
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                sc.close();
                return true;
            }

            sc.close();

            return false;

        } catch (Exception e) {
            System.out.println("[ERROR] Unable to read the file.");;
            return false;
        }
    }

    public String next() {
        if (!this.hasNext()) {
            return null;
        }

        try {            
            Scanner sc = new Scanner(file);

            for (int i = 0; i < this.actualParagraph; i++) {
                // ler até onde estamos
                sc.nextLine();
            }

            if (sc.hasNextLine()) {
                String ret = sc.nextLine();
                this.actualParagraph++;
                sc.close();
                return ret;
            }

            sc.close();
            return null;
        } catch (Exception e) {
            System.out.println("[ERROR] Unable to read the file.");;
            return null;
        }
    }
    
}
