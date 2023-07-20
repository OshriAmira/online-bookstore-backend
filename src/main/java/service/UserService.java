package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Boolean LoginAttempt(String email, String password) {
    	User user = userRepository.findByEmail(email);
    	if (user.getPassword().equals(password))
    		return true;
    		else
    			return false;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        userRepository.findById(id).ifPresent(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setEnabled(user.getEnabled());
            existingUser.setRoles(user.getRoles());
            userRepository.save(existingUser);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
