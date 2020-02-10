package com.bridgelabz.fundoonotes.dto;

public class NoteEdite {

	private String title;
	private String Take_a_note;
	private boolean archive;
	private boolean pin_note;
	private String colour;
	private boolean transh;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTake_a_note() {
		return Take_a_note;
	}
	public void setTake_a_note(String take_a_note) {
		Take_a_note = take_a_note;
	}
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	public boolean isPin_note() {
		return pin_note;
	}
	public void setPin_note(boolean pin_note) {
		this.pin_note = pin_note;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public boolean isTransh() {
		return transh;
	}
	public void setTransh(boolean transh) {
		this.transh = transh;
	}
	@Override
	public String toString() {
		return "NoteEdite [title=" + title + ", Take_a_note=" + Take_a_note + ", archive=" + archive + ", pin_note="
				+ pin_note + ", colour=" + colour + ", transh=" + transh + "]";
	}
	
	
}
