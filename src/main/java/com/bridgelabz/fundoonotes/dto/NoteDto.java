package com.bridgelabz.fundoonotes.dto;

public class NoteDto {
	private String Title;
	private String Take_a_note;
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
	@Override
	public String toString() {
		return "NoteDto [Title=" + Title + ", Take_a_note=" + Take_a_note + "]";
	}
	
	
}
