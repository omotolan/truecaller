package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;
import africa.semicolon.truecaller.data.repositories.ContactRepository;
import africa.semicolon.truecaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceImplTest {
    private ContactService contactService;
    private ContactRepository contactRepository;

    @BeforeEach
    public void startWith() {
        contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl(contactRepository);
    }

    @Test
    public void saveContact_findContactReturnsContact() {
        contactService.addContact("asa", "bool", "1234");
        Contact contact = contactService.findById(1);
        assertEquals("asa", contact.getFirstName());
        assertEquals("bool", contact.getLastName());
        assertEquals("1234", contact.getPhoneNumber());
        assertEquals(1, contactRepository.count());

    }

    @Test
    public void saveContact_deleteContactTest() {
        contactService.addContact("asa", "bool", "1234");
        contactService.addContact("love", "bool", "1234");
        contactService.addContact("alakija", "bool", "1234");
        Contact contact = contactService.findById(2);
        contactService.deleteContact(contact);
        Contact contact1 = contactService.findById(2);
        assertEquals("alakija", contact1.getFirstName());
        assertEquals("bool", contact1.getLastName());
        assertEquals("1234", contact1.getPhoneNumber());
        assertEquals(2, contactRepository.count());

    }

    @Test
    public void saveContact_updateContactTest() {
        contactService.addContact("asa", "bool", "1234");
        contactService.addContact("love", "bool", "1234");
        contactService.addContact("alakija", "bool", "1234");
        Contact contact = contactService.findById(2);
        Contact contact1 = new Contact("air", "omo", "1234");
        contactService.updateContact(contact, contact1);
        Contact contact2 = contactService.findById(2);
        assertEquals("air", contact2.getFirstName());
        assertEquals("omo", contact2.getLastName());
        assertEquals("1234", contact2.getPhoneNumber());
        assertEquals(3, contactRepository.count());
    }
}