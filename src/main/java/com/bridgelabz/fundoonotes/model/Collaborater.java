package com.bridgelabz.fundoonotes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Collaborater 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id;

private String  email;
@JsonIgnore
@ManyToOne
private Notes notes;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Notes getNotes() {
	return notes;
}
public void setNotes(Notes notes) {
	this.notes = notes;
}


}
