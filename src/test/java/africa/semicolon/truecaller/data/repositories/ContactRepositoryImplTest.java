package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contactRepository;

    @BeforeEach
    public void startWith() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void saveContact_countIsOneTest() {
        Contact contact = new Contact();
        contact.setFirstName("Tolani");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactRepository.count());

    }

    @Test
    public void saveContactTwice_countIsOneTest() {
        Contact contact = new Contact();
        contact.setFirstName("Tolani");

        Contact contact1 = new Contact();
        contact1.setFirstName("Akinsola");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);
        assertEquals(1, savedContact.getId());
        assertEquals(2, savedContact1.getId());
        assertEquals(2, contactRepository.count());

    }

    @Test
    public void saveContact_findByIdReturnsContactTest() {
        Contact contact = new Contact();
        contact.setFirstName("Tolani");

        Contact contact1 = new Contact();
        contact1.setFirstName("Akinsola");
        Contact savedContact = contactRepository.save(contact);

        Contact savedContact1 = contactRepository.save(contact1);

        Contact foundContact = contactRepository.findById(1);
        Contact foundContact1 = contactRepository.findById(2);


        assertEquals(1, foundContact.getId());
        assertEquals(2, foundContact1.getId());
        assertEquals("Tolani", foundContact.getFirstName());
        assertEquals("Akinsola", foundContact1.getFirstName());

    }

    @Test
    public void saveContact_findByFirstNameTest() {
        Contact contact = new Contact();
        contact.setFirstName("Tolani");

        Contact contact1 = new Contact();
        contact1.setFirstName("Akinsola");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);
        Contact foundContact = contactRepository.findByFirstName("tolani");
       // Contact foundContact1 = contactRepository.findByFirstName("Akinsola");
        assertEquals("Tolani", foundContact.getFirstName());

       // assertEquals("Akinsola", foundContact1.getFirstName());
    }

}