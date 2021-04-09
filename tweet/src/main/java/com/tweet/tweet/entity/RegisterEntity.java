package com.tweet.tweet.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "registerUser")
public class RegisterEntity {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    private String loginId;
    private String password;
    private String cPassword;
    private String contact;
    
	public RegisterEntity() {
	
	}

	public RegisterEntity(String firstName, String lastName, String email, String loginId, String password,
			String cPassword, String contact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.loginId = loginId;
		this.password = password;
		this.cPassword = cPassword;
		this.contact = contact;
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "RegisterEntity [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", loginId="
				+ loginId + ", password=" + password + ", cPassword=" + cPassword + ", contact=" + contact + "]";
	}

	
    
}
