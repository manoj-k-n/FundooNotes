package com.bridgelabz.fundoonotes.utility;

import java.io.UnsupportedEncodingException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Verification;

public class Utility {
	static BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

	public static String encoder(String str) {

		return bc.encode(str);
	}

	public static boolean passwordMatcher(String pas, String enpas) {
		return bc.matches(pas, enpas);
	}

	private String SECRET_KEY = "KEY";

	public String jwtToken(String name)
			throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {

		String tokens = JWT.create().withClaim("name", name).sign(Algorithm.HMAC512(SECRET_KEY));

		System.out.println(tokens);
		return tokens;
	}

	public String MailDetails(String token) 
	{
	 try {
		String jwt=JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token).getClaim("name").asString();
		return jwt;
	} catch (JWTVerificationException | IllegalArgumentException | UnsupportedEncodingException e) {
		
		e.printStackTrace();
		return null;
	}
		
	}
	
	

	

}
