package com.bridgelabz.fundoonotes.dto;

public class NoteDto {
	private String Title;
	private String Take_a_note;
	private String colour;
	private boolean pin;
	private boolean archive;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getTake_a_note() {
		return Take_a_note;
	}
	public void setTake_a_note(String take_a_note) {
		Take_a_note = take_a_note;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public boolean isPin() {
		return pin;
	}
	public void setPin(boolean pin) {
		this.pin = pin;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	@Override
	public String toString() {
		return "NoteDto [Title=" + Title + ", Take_a_note=" + Take_a_note + ", colour=" + colour + ", pin=" + pin
				+ ", archive=" + archive + "]";
	}
	
	
	
}
