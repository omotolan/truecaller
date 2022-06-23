package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {

    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
//        int n = 0;
//        Contact contact1;
//        for (int i = 0; i < contacts.size(); i++) {
//            contact1 = contacts.get(i);
//            n = contact1.getId();
//            if (n > 0) {
//                contacts.set(n, contact);
//            }
//        }
        contact.setId(contacts.size() + 1);
        contacts.add(contact);

        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public List<Contact> findContact(String value) {
        List<Contact> myContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (value.equalsIgnoreCase(contact.getFirstName())
                    || value.equalsIgnoreCase(contact.getLastName())
                    || value.equals(contact.getPhoneNumber())) {
                myContacts.add(contact);
            }
        }
        return myContacts;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public Contact delete(Contact contact) {

        Contact contact1 = new Contact();
        for (int i = 0; i < contacts.size(); i++) {
            contact1 = contacts.get(i);
            if (contact.equals(contact1)) {
                contacts.remove(contact);
                return contact1;
            }
        }
        return null;
    }

}
