package com.bridgelabz.fundoonotes.service;

import javax.validation.Valid;

import com.bridgelabz.fundoonotes.dto.NoteDto;

public interface ServiceNotes 
{

	boolean creatnots(NoteDto note, String token);

	boolean updateArchive(long id, @Valid String token);

	boolean updatePin(long id, @Valid String token);

	boolean updateTrash(@Valid String token, long id);

	boolean colourChange(String token, long id, String colour);

	boolean getNotes(@Valid String token, long id);

}
