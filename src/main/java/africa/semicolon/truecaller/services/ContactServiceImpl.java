package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepository;

public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

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
    public void updateContact(Contact contact, Contact contact1) {
        contactRepository.update(contact, contact1);
    }
}
