package service;

import java.util.List;
import java.util.Optional;

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
    
    public ContactMessage updateMessageStatus(Long id, boolean newStatus) {
        Optional<ContactMessage> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            ContactMessage message = optionalMessage.get();
            message.setStatus(newStatus);
            return messageRepository.save(message);
        }
        return null; // Or throw an exception if the message with the given id does not exist
    }
    
    
    
}

