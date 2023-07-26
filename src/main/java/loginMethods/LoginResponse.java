package loginMethods;

import java.util.List;

public class LoginResponse {
    private String firstName;
    private String lastName;
    private boolean loginStatus;
    private long id;
    private List<String> roles;
    
    public LoginResponse (){
    
    }

    public LoginResponse(String firstName, String lastName, boolean loginStatus, Long id, List<String> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginStatus = loginStatus;
        this.id = id;
        this.roles = roles;
    }
    
    // Getters and setters 

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

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public List<String> getRole() {
		return roles;
	}

	public void setRole(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "LoginResponse [firstName=" + firstName + ", lastName=" + lastName + ", loginStatus=" + loginStatus
				+ ", id=" + id + ", roles=" + roles + "]";
	}



	



}

