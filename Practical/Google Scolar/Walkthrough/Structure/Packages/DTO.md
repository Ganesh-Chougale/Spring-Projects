## RegistrationDTO.java  
```java
package com.Verligence.GSRPM.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationDTO {
	@NotBlank(message = "username is required.")
	@Size(min = 5, max = 50, message = "username must be between 5 & 50 characters.")
	private String username;
	
	@NotBlank(message = "Email is required.")
	@Email(message = "Invalid email format.")
	private String email;
	
	@NotBlank(message = "password is required.")
	@Size(min = 8, message = "password must be atleast 8 characters long.")
	private String password;
	
	@NotBlank(message = "please confirm your password.")
	private String confirmPassword;

	
	// getters setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@AssertTrue(message = "Passwords do not match.")
	private boolean isPasswordMatching() {
		return password != null && password.equals(confirmPassword);
	}

}
```  