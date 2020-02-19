package com.bridgelabz.fundoonotes.service;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.NoteEdite;
import com.bridgelabz.fundoonotes.model.Notes;

public interface ServiceNotes 
{

	boolean creatnots(NoteDto note, String token);

	boolean updateArchive(long id, @Valid String token);

	boolean updatePin(long id, @Valid String token);

	boolean updateTrash(@Valid String token, long id);

	boolean colourChange(String token, long id, String colour);

	Notes getNotes(@Valid String token, long id);

	List<Notes> getAll(@Valid String token);

	boolean delete(String token,long id);

	boolean reminder(String token, long id,String reminder);

	boolean addlabels(String token, long id, long idl);

	boolean edite(String token, long id, NoteEdite edite);

	boolean editeText(String token, long idn, Notes edite);

}
