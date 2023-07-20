package controller;


import model.User;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;

import entitiesDTO.UserDTO;
import repository.UserRepository;



@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private final UserRepository userRepository;

    //@Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
//    @PostMapping("/login")
//    public Boolean LoginAttempt(@RequestBody String email, String password) {
//    	User user = userRepository.findByEmail(email);
//    	if (user.getPassword().equals(password))
//    		return true;
//    		else
//    			return false;
//    }
    
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
    	User user = userRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	return convertToDTO(user); 			
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Update the user fields
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setEnabled(user.getEnabled());
            existingUser.setRoles(user.getRoles());

            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    protected UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setEnabled(user.getEnabled());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }
    
    
}

