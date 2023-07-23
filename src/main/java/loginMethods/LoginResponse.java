package loginMethods;

public class LoginResponse {
    private String firstName;
    private String lastName;
    private boolean loginStatus;
    private long id;
    
    public LoginResponse (){
    
    }

    public LoginResponse(String firstName, String lastName, boolean loginStatus, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginStatus = loginStatus;
        this.id = id;
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

	@Override
	public String toString() {
		return "LoginResponse [firstName=" + firstName + ", lastName=" + lastName + ", loginStatus=" + loginStatus
				+ ", id=" + id + "]";
	}


}

