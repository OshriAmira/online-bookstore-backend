package service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;
import model.Role;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    //@Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> updateRole(Long id, Role updatedRole) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            role.setName(updatedRole.getName());
            return Optional.of(roleRepository.save(role));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteRole(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            roleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    // Add any additional methods as needed

}

