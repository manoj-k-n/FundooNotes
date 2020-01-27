package com.bridgelabz.fundoonotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.CollaboraterDto;
import com.bridgelabz.fundoonotes.model.Collaborater;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.ServiceCollaboratore;

@RestController
public class CollaboratoreController 
{
	
	@Autowired
	private ServiceCollaboratore service;
@PostMapping("/collaboratore/{idn}")
public ResponseEntity<Response> collaborate(@RequestHeader String token ,@PathVariable long idn,@RequestBody CollaboraterDto email)
{
	boolean b=service.collaboratore(token,idn,email);
	if(b)
	{
		return ResponseEntity.ok().body(new Response("Successfull",200,""));
	}
	else
	{
		return ResponseEntity.ok().body(new Response("Failed",400,""));
	}
}
@DeleteMapping("/deletcollaborate/{idc}")
public ResponseEntity<Response> collaborate(@RequestHeader String token,@PathVariable long idc)
{
	boolean b=service.deletCollaborate(token,idc);
	if(b)
	{
		return ResponseEntity.ok().body(new Response("Successfull",200,""));
	}
	else
	{
		return ResponseEntity.ok().body(new Response("Failed",400,""));
	
	}
}

@GetMapping("/getAllCollaborate/{idn}")
public ResponseEntity<Response> getAll(@RequestHeader String token,@PathVariable long idn)
{
	List<Collaborater> b=service.getAllCollaborate(token,idn);
	if(b!=null)
	{
		return ResponseEntity.ok().body(new Response("Successfull", 200,b));
	}
	else
	{
		return ResponseEntity.ok().body(new Response("Failed",400,b));
	}
}
}
