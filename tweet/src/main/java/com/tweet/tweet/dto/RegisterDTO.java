package com.tweet.tweet.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

	  	private String firstName;
	    private String lastName;
	    private String email;
	    private String loginId;
	    private String contact;
	    
	    
		public RegisterDTO() {
		}

		public RegisterDTO(String firstName, String lastName, String email, String loginId, String contact) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.loginId = loginId;
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
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
	
	    
}
