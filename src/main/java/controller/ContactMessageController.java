package controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.ContactMessage;
import repository.ContactMessageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/messages")
public class ContactMessageController {
	
    private final ContactMessageRepository messageRepository;

    public ContactMessageController(ContactMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public ContactMessage createMessage(@RequestBody ContactMessage message) {
        // Save the message in the database
        return messageRepository.save(message);
    }
}
