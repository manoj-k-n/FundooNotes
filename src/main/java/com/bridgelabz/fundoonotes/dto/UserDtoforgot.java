package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDtoforgot 
{
@NotNull(message = "Email cannot be empty")
@Email(message = "Invalid Email Id")
private String email;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
