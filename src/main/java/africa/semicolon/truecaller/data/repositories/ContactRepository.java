package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();
    Contact findByFirstName(String firstName);
    Contact findById(int id);
    Contact delete(String firstName);
    Contact delete(Contact contact);
    Contact update(String oldFirstName, String newFirstName);
    Contact update(Contact contact1,Contact contact);
}
