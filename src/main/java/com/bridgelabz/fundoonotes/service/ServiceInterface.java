package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.UserDTOLogin;

import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.dto.UserDtoReset;
import com.bridgelabz.fundoonotes.dto.UserDtoforgot;
import com.bridgelabz.fundoonotes.model.User;

public interface ServiceInterface {

	boolean register(UserDto user);
	String login(UserDTOLogin user);
	boolean verificationMail(String token);
	String forgot(UserDtoforgot user);
	boolean resetpass(String token, UserDtoReset user);
}
