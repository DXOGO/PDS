import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactsStorageBin implements ContactsStorageInterface {
    String fileName;

    ContactsStorageBin(String fileName) {
        this.fileName = fileName;
    }

    public List<Contact> loadContacts() {
        // ler o ficheiro e retornar a lista
        List<Contact> contacts = new ArrayList<Contact>();

        try {            
            File file = new File(this.fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split("\t");
                Contact c = new Contact(parts[0], parts[1]);
                contacts.add(c);
                line = reader.readLine();
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] File doesn't exist!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    public boolean saveContacts(List<Contact> list) {
        try {            
            File file = new File(this.fileName);
            BufferedWriter bwr = new BufferedWriter( new FileWriter(file) );

            for (Contact c : list) {
                bwr.write(c.toString() + "\n");
            }
            bwr.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
