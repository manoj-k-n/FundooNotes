package com.bridgelabz.fundoonotes.serviceImplemetaion;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.bridgelabz.fundoonotes.Repository.UserRepository;
import com.bridgelabz.fundoonotes.dto.UserDTOLogin;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.dto.UserDtoReset;
import com.bridgelabz.fundoonotes.dto.UserDtoforgot;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.service.ServiceInterface;
import com.bridgelabz.fundoonotes.utility.MailVerification;
import com.bridgelabz.fundoonotes.utility.Utility;

@Service
public class UserServiceImplementation implements ServiceInterface {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private Utility util;

	@Autowired
	private MailVerification mail;

	@Override
	public boolean register(UserDto user) {

		try {

			User us = new User();

			us.setFistname(user.getFirstname());
			us.setLastname(user.getLastname());
			us.setMobileno(user.getMobileno());
			us.setPassword(util.encoder(user.getPassword()));
			us.setPassword2(util.encoder(user.getPassword2()));
			us.setMail(user.getEmail());
			us.setCreatdate();

			userRepo.save(us);
			
			String Token = util.jwtToken(us.getMail());
			String token = "";
			mail.sendVerificationMail(us.getMail(), Token);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public String login(UserDTOLogin user) {
		User u = userRepo.findOneByEmail(user.getEmail());
		
		if (u != null && u.getMail().equals(user.getEmail())
				&& util.passwordMatcher(user.getPassword(), u.getPassword()) && u.isIs_email_verify()) {
			try {
				String s=util.jwtToken(u.getMail());
				return s;
			} catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {

				e.printStackTrace();
				return null;
			}

		} else {
			return null;
		}

	}

	@Override
	public boolean verificationMail(String token) {
		System.out.println(token);
		String JWT = util.MailDetails(token);

		User uu = userRepo.findOneByEmail(JWT);

		if (uu != null) {
			if (!uu.isIs_email_verify()) {
				uu.setIs_email_verify(true);
				System.out.println(uu);
				userRepo.save(uu);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public boolean forgot(UserDtoforgot user) {
		User u = userRepo.findOneByEmail(user.getEmail());
		if (u != null && u.isIs_email_verify() == true) {
			try {
				String token = util.jwtToken(user.getEmail());
				mail.sendpassword(u.getMail(), token);
				return true;
			} catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {

				e.printStackTrace();
				return false;
			}
		} else {
			return false;

		}

	}

	@Override
	public boolean resetpass(String token, UserDtoReset user) {
		try {
			String JWT = util.MailDetails(token);
			User u = userRepo.findOneByEmail(JWT);
			u.setPassword(util.encoder(user.getPassword()));
			u.setPassword2(util.encoder(user.getPasswordagain()));
			userRepo.save(u);
			
			return true;

		} catch (IllegalArgumentException | JWTCreationException e) {
			e.printStackTrace();
			return false;
		}

	}

}
