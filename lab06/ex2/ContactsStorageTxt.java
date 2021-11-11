import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ContactsStorageTxt implements ContactsStorageInterface {
    String fileName;

    ContactsStorageTxt(String fileName) {
        this.fileName = fileName;
    }

    public List<Contact> loadContacts() {
        // ler o ficheiro e retornar a lista
        List<Contact> contacts = new ArrayList<Contact>();

        String str = "";
        String[] word = {};

        try {
            File file = new File(this.fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                word = sc.nextLine().split(" ");
                Contact c = new Contact(word[0], Integer.parseInt(word[1]));
                contacts.add(c);
            }

            sc.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] File doesn't exist!");
            return null;
        }

        return contacts;
    }

    public boolean saveContacts(List<Contact> list) {
        // escrever no ficheiro
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));

            for (Contact c : list) {
                writer.write(c.toString() + "\n");
            }
            
            writer.close();

        } catch (IOException e) {
            System.err.println("[ERROR] Could not write to file!");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
