package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

import java.util.ArrayList;

public class ContactRepositoryImpl implements ContactRepository {

    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.add(contact);

        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (Contact contact : contacts) {

            if (firstName.equalsIgnoreCase(contact.getFirstName())) {
                return contact;

            } else throw new NullPointerException("Name does not exist");
        }
        return null;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }

    @Override
    public Contact delete(String firstName) {
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contacts.remove(contact);
                return contact;
            }
        }

        return null;
    }

    @Override
    public Contact delete(Contact contact) {
        Contact contact1;
        for (int i = 0; i < contacts.size(); i++) {
            contact1 = contacts.get(i);
            if (contact.equals(contact1)) {
                contacts.remove(contact);
                return contact1;
            }


        }
        return null;
    }

    @Override
    public Contact update(String oldFirstName, String newFirstName) {

        Contact contact = findByFirstName(oldFirstName);
        contact.setFirstName(newFirstName);

        return contact;
    }

    @Override
    public Contact update(Contact oldContact, Contact newContact) {
        Contact contact1;
        for (int i = 0; i < contacts.size(); i++) {
            contact1 = contacts.get(i);
            if (oldContact.equals(contact1)) {
                contacts.set(i, newContact);

                return newContact;
            }

        }
        return null;
    }
}
