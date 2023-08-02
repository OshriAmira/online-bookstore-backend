package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import model.ContactMessage;
import repository.ContactMessageRepository;
import service.ContactMessageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/messages")
public class ContactMessageController {
	
    private final ContactMessageRepository messageRepository;
    private final ContactMessageService messageService; 

    public ContactMessageController(ContactMessageRepository messageRepository, ContactMessageService messageService) {
        this.messageRepository = messageRepository;
        this.messageService = messageService;
    }
    
    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllContactMessage() {
        List<ContactMessage> contactMessage = messageRepository.findAll();
        return ResponseEntity.ok(contactMessage);
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public ContactMessage createMessage(@RequestBody ContactMessage message) {
        // Save the message in the database
        return messageRepository.save(message);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> findContactMessageById(@PathVariable Long id) {
        Optional<ContactMessage> optionalContactMessage = messageRepository.findById(id);
        if (optionalContactMessage.isPresent()) {
        	ContactMessage contactMessage = optionalContactMessage.get();
            return ResponseEntity.ok(contactMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ContactMessage> updateMessageStatus(@PathVariable Long id, @RequestBody boolean newStatus) {
    	System.out.println ("status IN");
        ContactMessage updatedMessage = messageService.updateMessageStatus(id, newStatus);
        if (updatedMessage != null) {
            return ResponseEntity.ok(updatedMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactMessage(@PathVariable Long id) {
    	messageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
