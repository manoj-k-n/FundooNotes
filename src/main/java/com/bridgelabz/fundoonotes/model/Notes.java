package com.bridgelabz.fundoonotes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	private String Title;

	private String Take_a_note;

	@Column(columnDefinition = "boolean default false")
	private boolean Archive;

	private String colour;
	@Column(name = "Creation_Date")
	private Date creatDate;
	@Column(columnDefinition = "boolean default false")
	private boolean Pin_Note;
	@JsonIgnore

	@ManyToOne
	private User user;

	@Column(columnDefinition = "boolean default false")
	private boolean trash;
	private String LocalReminderStatus;
	private Date reminderDate;
	private Date UpdateDate;
	@JsonIgnore
	@ManyToMany
	private List<Labels> label;

	public List<Labels> getLabel() {
		return label;
	}

	public void setLabel(List<Labels> label) {
		this.label = label;
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Date reminderDate) {
		this.reminderDate = new Date();
	}

	public Date getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = new Date();
	}

	public String getLocalReminderStatus() {
		return LocalReminderStatus;
	}

	public void setLocalReminderStatus(String localReminderStatus) {
		LocalReminderStatus = localReminderStatus;
	}

	public boolean isTrash() {
		return trash;
	}

	public void setTrash(boolean trash) {
		this.trash = trash;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Object getTitle() {
		return Title;
	}

	public void setTitle(String object) {
		Title = object;
	}

	public Object getTake_a_note() {
		return Take_a_note;
	}

	public void setTake_a_note(String take_a_note) {
		Take_a_note = take_a_note;
	}

	public boolean isArchive() {
		return Archive;
	}

	public void setArchive(boolean archive) {
		Archive = archive;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = new Date();
	}

	public boolean isPin_Note() {
		return Pin_Note;
	}

	public void setPin_Note(boolean pin_Note) {
		Pin_Note = pin_Note;
	}

	@Override
	public String toString() {
		return "Notes [Id=" + Id + ", Title=" + Title + ", Take_a_note=" + Take_a_note + ", Archive=" + Archive
				+ ", colour=" + colour + ", creatDate=" + creatDate + ", Pin_Note=" + Pin_Note + ", user=" + user + "]";
	}

}
