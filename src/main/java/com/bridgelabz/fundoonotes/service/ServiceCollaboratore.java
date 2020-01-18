package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.CollaboraterDto;

public interface ServiceCollaboratore 
{

	boolean collaboratore(String token, long idn, CollaboraterDto email);

}
