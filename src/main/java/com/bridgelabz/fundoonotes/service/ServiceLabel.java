package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.dto.LabelDto;
import com.bridgelabz.fundoonotes.model.Labels;
import com.bridgelabz.fundoonotes.model.Notes;


public interface ServiceLabel 
{
	boolean createLabels(LabelDto label, String token);

	boolean deletlabel(String token, long id);

	boolean updatelabels(String token, long id, LabelDto name);

	List<Labels> getAllLabels(String token);

	List<Notes> getAllNotes(String token, long id);

	boolean changeLabels(String token, long idl, long id);

	boolean removelabel(String token, long idl, long id);
}
