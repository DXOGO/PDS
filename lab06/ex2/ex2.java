public class ex2 {
    public static void main(String[] args) {
        Contact c1 = new Contact("Nome1", 12345);
        Contact c2 = new Contact("Nome2", 12222);
        Contact c3 = new Contact("Nome3", 12233);
        Contact c4 = new Contact("Nome4", 12234);
        Contact c5 = new Contact("Nome5", 54321);
        Contact c6 = new Contact("Nome6", 67890);
        Contact c7 = new Contact("Nome7", 14235);

        ContactsInterface c_man = new Contacts();
        ContactsInterface c_aux = new Contacts();

        c_man.add(c1);
        c_man.add(c2);
        c_man.add(c3);
        c_man.add(c4);

        System.out.println(c_man.getByName("Nome1"));

        c_man.saveAndClose(new ContactsStorageTxt("out.txt"));

        c_aux.openAndLoad(new ContactsStorageTxt("out.txt"));

        c_aux.add(c5);
        c_aux.add(c6);
        c_aux.add(c7);

        System.out.println(c_aux.exist(c6));
        System.out.println(c_man.exist(c6));

        c_aux.saveAndClose(new ContactsStorageTxt("out1.txt"));
    }
}
