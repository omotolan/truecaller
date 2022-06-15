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
}