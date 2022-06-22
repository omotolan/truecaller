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

    @Test
    public void deleteContactByFirstNameTest() {
        Contact contact = new Contact();
        contact.setFirstName("Tolani");

        Contact contact1 = new Contact();
        contact1.setFirstName("Akinsola");
        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);
        Contact contactFound = contactRepository.delete("Akinsola");
        //   Contact contact2 = contactRepository.findById(2);
        assertEquals(1, contactRepository.count());
        // assertEquals("", contact2.getFirstName());
    }

    @Test
    public void deleteContactTest() {
        Contact contact = new Contact("Tolani", "Akinsola", "08182");
        Contact contact1 = new Contact("Tola", "Omo", "08185");
        Contact contact2 = new Contact("Tola", "Omo", "08185");

        Contact contact3 = contactRepository.save(contact);
        Contact contact4 = contactRepository.save(contact1);
        Contact contact5 = contactRepository.save(contact2);

        Contact contact6 = contactRepository.delete(contact1);
        assertEquals(2, contactRepository.count());

    }

    @Test
    public void updateContactFirstNameTest() {
        Contact contact = new Contact("Tolani", "Akinsola", "08182");
        Contact contact1 = new Contact("Tola", "Omo", "08185");
        Contact contact2 = new Contact("omo", "Omo", "08185");

        Contact contact3 = contactRepository.save(contact);
        Contact contact4 = contactRepository.save(contact1);
        Contact contact5 = contactRepository.save(contact2);


        Contact contact6 = contactRepository.update("Tolani", "Bashiru");
        assertEquals("Bashiru", contact6.getFirstName());
        assertEquals(3, contactRepository.count());

    }

    @Test
    public void updateContactTest() {
        Contact contact = new Contact("Tolani", "Akinsola", "08182");
        Contact contact1 = new Contact("Tola", "Omo", "08185");
        Contact contact2 = new Contact("omo", "Omo", "08185");

        Contact contact3 = contactRepository.save(contact);
        Contact contact4 = contactRepository.save(contact1);
        Contact contact5 = contactRepository.save(contact2);

        Contact contact6 = new Contact("Love", "Alakija", "08185");
        Contact contact7 = contactRepository.update(contact4, contact6);
        assertEquals(3, contactRepository.count());
        assertEquals("Love", contact7.getFirstName());
        assertEquals("Alakija", contact7.getLastName());
        assertEquals("08185", contact7.getPhoneNumber());

    }

}