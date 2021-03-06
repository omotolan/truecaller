package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;

import java.util.List;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int i);

    void deleteContact(Contact Contact);

    void updateContact(Contact contact, String firstName, String lastname, String phoneNumber);

    List<Contact> findContact(String value);
}
