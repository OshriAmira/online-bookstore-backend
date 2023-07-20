package controller;


import model.LoginRequest;
import model.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import entitiesDTO.UserDTO;
import repository.LoginRepository;



@RequestMapping("/login1")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    private final LoginRepository loginRepository;


    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    
    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = loginRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getFormData().getEmail();
        String password = loginRequest.getFormData().getPassword();
        System.out.println(email);
        System.out.println(password);
        User user = loginRepository.findByEmail(email);
        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
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

