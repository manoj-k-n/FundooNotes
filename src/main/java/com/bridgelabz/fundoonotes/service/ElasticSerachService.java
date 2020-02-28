package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.model.Notes;

public interface ElasticSerachService 
{

	String createNote(Notes notes);

	void updateNote(long noteId);

	String deleteNote(long noteId);

	List<Notes> searchbytitle(String title);

}
