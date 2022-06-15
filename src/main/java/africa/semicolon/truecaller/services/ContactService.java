package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int i);
}
