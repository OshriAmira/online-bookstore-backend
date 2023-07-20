package service;

import java.util.List;


import org.springframework.stereotype.Service;

import model.ContactMessage;
import repository.ContactMessageRepository;

@Service
public class ContactMessageService {
    private final ContactMessageRepository messageRepository;

    
    public ContactMessageService(ContactMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ContactMessage createMessage(ContactMessage message) {
        // Save the message in the database
        return messageRepository.save(message);
    }
    
	
    public List<ContactMessage> getAllContactMessage() {
        return messageRepository.findAll();
    }
    
    public void deleteContactMessage(Long id) {
    	messageRepository.deleteById(id);
    }
    
    
    
}

