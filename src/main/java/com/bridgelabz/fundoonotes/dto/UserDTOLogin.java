package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDTOLogin {

	@NotNull(message = "Email cannot be empty")
	@Email
	private String email;
	@NotNull(message = "password cannot be empty")
	private String password;

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

	@Override
	public String toString() {
		return "UserDTOLogin [email=" + email + ", password=" + password + "]";
	}
}
