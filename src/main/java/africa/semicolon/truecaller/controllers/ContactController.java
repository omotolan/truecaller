package africa.semicolon.truecaller.controllers;

import africa.semicolon.truecaller.services.ContactService;
import africa.semicolon.truecaller.services.ContactServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private final ContactService contactService = new ContactServiceImpl();

    @PostMapping("/contact")
    public String addContact(@RequestBody RequestDto requestDto) {
        contactService.addContact(requestDto.getFirstName(),requestDto.getLastName(),requestDto.getPhoneNumber());
        return "Added successfully";
    }

    @GetMapping("/contact/{firstName}")
    public String findContact(@PathVariable String firstName) {
        return contactService.findContact(firstName).toString();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RequestDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}

