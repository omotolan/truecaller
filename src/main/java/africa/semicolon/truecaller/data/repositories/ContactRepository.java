package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);

    int count();

    List<Contact> findContact(String value);

    Contact findById(int id);

    Contact delete(Contact contact);

}
