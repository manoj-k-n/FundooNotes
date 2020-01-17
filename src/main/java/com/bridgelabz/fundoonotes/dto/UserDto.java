package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    
	@NotNull (message="fistname cannot be empty")
	private String firstname;
	
	@NotNull(message="lastname cannot be empty")
	private String lastname;
	
	@NotNull(message = "email cannot be empty")
	@Email
//	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "give an valid email")
	private String email;
	@NotNull(message = "Mobile No cannot be empty")
	private long mobileno;
	
	@NotNull(message = "password cannot be empty")
	@Size(min = 8,max = 15,message = "Minimum 8 value")
	private String password;
	
	@NotNull(message = "Reenetr the Password")
	private String passwordagain;
	
	

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return passwordagain;
	}
	public void setPassword2(String password2) {
		this.passwordagain = password2;
	}
	
	
	/*
	 * public void setCreatDate() { D this.creatDate = creatDate; }
	 */
	
}
