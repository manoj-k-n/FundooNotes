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
public class Labels {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@NotNull
	private String labelTitle;
     @JsonIgnore
	@ManyToMany(mappedBy = "label")
	private List<Notes> noteList;

	@JsonIgnore
	@ManyToOne
	private User user;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(String labelTitle) {
		this.labelTitle = labelTitle;
	}

	public List<Notes> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Notes> noteList) {
		this.noteList = noteList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Labels [Id=" + Id + ", labelTitle=" + labelTitle + ", noteList=" + noteList + ", user=" + user + "]";
	}

}
