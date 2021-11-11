import java.util.ArrayList;
import java.util.List;

public class Contacts implements ContactsInterface {
    ArrayList<Contact> contacts = new ArrayList<>();
    ContactsStorageInterface store = null;

    public void openAndLoad(ContactsStorageInterface store) {
        this.store = store;
        for (Contact c : store.loadContacts()) {
            System.out.println(c);
            this.contacts.add(c);
        }
    }

    public void saveAndClose() {
        if (!this.store.saveContacts(this.contacts)) {
            System.out.println("[ERROR] Couldn't save the file");
        }
    }

    public void saveAndClose(ContactsStorageInterface store) {
        if (!store.saveContacts(this.contacts)) {
            System.out.println("[ERROR] Couldn't save the file");
        }
    }

    public boolean exist(Contact contact) {
        return this.contacts.contains(contact);
    }

    public Contact getByName(String name) {
        for (Contact c : this.contacts) {
            if (c.getName() == name) {
                return c;
            }
        }
        System.out.println("[ERROR] That name does not belong to any contact");
        return null;
    }

    public boolean add(Contact contact) {
        return this.contacts.add(contact);
    }

    public boolean remove(Contact contact) {
        return this.contacts.remove(contact);
    }
}
