package entitiesDTO;

import java.util.Set;

import model.Role;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean enabled;
    private Set<Role> roles;
    
    // Constructors
    
    // Default constructor
    public UserDTO() {
    }
    
	public UserDTO(Long id, String firstName, String lastName, String email, Boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.enabled = enabled;
		this.roles = roles;
	}

	//getters, and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}
}

