package com.bridgelabz.fundoonotes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.fundoonotes.Repository.NoteRepository;
import com.bridgelabz.fundoonotes.serviceImplemetaion.NotsServiceImp;
import com.bridgelabz.fundoonotes.utility.Utility;

@Configuration
public class ApplicationConfig 
{

	@Bean
	public Utility getUserObject() {
		return new Utility();
	}
	

}
