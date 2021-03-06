package com.bridgelabz.fundoonotes.model;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class User 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@NotNull
private String firstname;
private String lastname;

@Column(unique = true)
@NotNull
private String email;

@Column(unique = true)
@NotNull
private long mobileno;
@NotNull
private String password;
@NotNull
private String passwordagain;
@CreatedDate
private Date creatdate;
@Column(columnDefinition = "boolean default false")
private boolean is_email_verify;
@OneToMany(mappedBy = "user")
private List<Notes> notes;



public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



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



public String getPasswordagain() {
	return passwordagain;
}



public void setPasswordagain(String passwordagain) {
	this.passwordagain = passwordagain;
}



public Date getCreatdate() {
	return creatdate;
}



public void setCreatdate() {
	this.creatdate =new Date();
}



public boolean isIs_email_verify() {
	return is_email_verify;
}



public void setIs_email_verify(boolean is_email_verify) {
	this.is_email_verify = is_email_verify;
}



public List<Notes> getNotes() {
	return notes;
}



public void setNotes(List<Notes> notes) {
	this.notes = notes;
}



@Override
public String toString() {
	return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", mobileno="
			+ mobileno + ", password=" + password + ", password2=" + passwordagain + ", creatdate=" + creatdate
			+ ", is_email_verify=" + is_email_verify + "]";
}


}
