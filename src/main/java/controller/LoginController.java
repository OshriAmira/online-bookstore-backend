package controller;


import model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import entitiesDTO.UserDTO;
import loginMethods.LoginRequest;
import loginMethods.LoginResponse;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getFormData().getEmail();
        String password = loginRequest.getFormData().getPassword();
        User user = loginRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
        	List<String> roleNames = user.getRoles().stream()
                    .map(role -> role.getName().toString()) // Assuming RoleName is an Enum
                    .collect(Collectors.toList());
        	System.out.println(roleNames);
        	// Create a LoginResponse object containing the user's full name and login status
        	LoginResponse response = new LoginResponse(
                    user.getFirstName(),
                    user.getLastName(),
                    true,
                    user.getId(),
                    roleNames
                );
        	return ResponseEntity.ok(response);
        	} else {
            // Create a LoginResponse object with empty name fields and login status as false
        		LoginResponse response = new LoginResponse("", "", false, 0L, Collections.emptyList());
                return ResponseEntity.ok(response);
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

