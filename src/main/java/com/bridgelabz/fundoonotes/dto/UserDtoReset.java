package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.NotNull;

public class UserDtoReset 
{
@NotNull(message = "Password cannot be empty")
private String password;

@NotNull(message = "Password cannot be empty")
private String passwordagain;

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPasswordagain() {
	return passwordagain;
}

public void setPasswordagain(String passwordagain) {
	this.passwordagain = passwordagain;
}

}
