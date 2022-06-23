package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepository;
import africa.semicolon.truecaller.data.repositories.ContactRepositoryImpl;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository = new ContactRepositoryImpl();


    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);

    }

    @Override
    public Contact findById(int i) {
        return contactRepository.findById(i);

    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);

    }

    @Override
    public void updateContact(Contact contact, String firstName, String lastname, String phoneNumber) {

        if (firstName.length() != 0) {
            contact.setFirstName(firstName);
        } else if (lastname.length() != 0) {
            contact.setLastName(lastname);
        } else if (phoneNumber.length() != 0) {
            contact.setPhoneNumber(phoneNumber);
        }
        contactRepository.save(contact);
    }


    @Override
    public List<Contact> findContact(String value) {
        return contactRepository.findContact(value);

    }
}
