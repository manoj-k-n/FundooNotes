package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.dto.CollaboraterDto;
import com.bridgelabz.fundoonotes.model.Collaborater;

public interface ServiceCollaboratore 
{

	boolean collaboratore(String token, long idn, CollaboraterDto email);

	boolean deletCollaborate(String token, long idc);

	List<Collaborater> getAllCollaborate(String token, long idn);

}
