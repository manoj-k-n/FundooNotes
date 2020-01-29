package com.bridgelabz.fundoonotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.UserDTOLogin;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.dto.UserDtoReset;
import com.bridgelabz.fundoonotes.dto.UserDtoforgot;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.ServiceInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping
public class UserController {
	@Autowired
	private ServiceInterface service;
	
 
	@PostMapping("/users/register")
	public ResponseEntity<Response> register(@Valid @RequestBody UserDto user) {

	
		Boolean is_registered_succ = service.register(user);

		if (is_registered_succ) {
			return ResponseEntity.ok().body(new Response("Registration Successfull", 200,user));
		}
		return ResponseEntity.ok().body( new Response("Registration Fail", 400, user));
	}

	

	@PostMapping("/users/login/")
	public ResponseEntity<Response> login( @RequestBody UserDTOLogin user) {
		String is_login = service.login(user);
		if(is_login!=null)
		{
			return ResponseEntity.ok().body(new Response("Login Success",200,is_login));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Login Fail",400,is_login));
		}
	}
	
	@GetMapping("users/verify/{Token}")
	public ResponseEntity<Response> verfiy(@PathVariable("Token") String Token)
	{
		boolean b=service.verificationMail(Token);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Verification Success",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Verification Faild",400,""));
		}
		
	}
	
	@PostMapping("users/forgotpassword")
	public ResponseEntity<Response> forgotpassword(@RequestBody UserDtoforgot user)
	{
	  String token= service.forgot(user);
	  if(token!=null)
	  {
		  return ResponseEntity.ok().body(new Response("Successfull",200,token));
	  }
	  else
	  {
		  return ResponseEntity.ok().body(new Response("Faild",400, token));
	  }
	}
	
	@PostMapping("users/resetpassword/{Token}")
	public ResponseEntity<Response> resetpassword(@PathVariable("Token") String Token, @RequestBody UserDtoReset user )
	{
		boolean b=service.resetpass(Token,user);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Success",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Faild", 400,""));
		}
	}

}
