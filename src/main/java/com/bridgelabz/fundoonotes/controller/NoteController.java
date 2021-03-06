package com.bridgelabz.fundoonotes.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.NoteEdite;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.ServiceNotes;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoteController {
	@Autowired
	private ServiceNotes service;

	@PostMapping("/notes/{Token}")
	public ResponseEntity<Response> creatnots(@Valid @RequestBody NoteDto note, @PathVariable("Token") String Token) {
      System.out.println(note);
      System.out.println("......");
      System.out.println("helll "+Token);
		boolean b = service.creatnots(note, Token);
		if (b) {
			return ResponseEntity.ok().body(new Response("Successfull", 200, ""));
		} else {
			return ResponseEntity.ok().body(new Response("Failed", 400, ""));
		}
	}

	@PutMapping("/archive/{Id}/{Token}")
	public ResponseEntity<Response> updateAchive(@Valid @PathVariable("Token") String token,
			@PathVariable("Id") long Id) {

		boolean b = service.updateArchive(Id, token);
		if (b) {
			return ResponseEntity.ok().body(new Response("Successfull", 200, Id));
		} else {
			return ResponseEntity.ok().body(new Response("Failed", 400, Id));
		}
	}

	@PutMapping("/pin/{Id}/{Token}")
	public ResponseEntity<Response> updatePin(@Valid @PathVariable("Token") String token,
			@PathVariable("Id") long Id) {
		boolean b = service.updatePin(Id, token);
		if (b) {
			return ResponseEntity.ok().body(new Response("Successfull", 200, Id));
		} else {
			return ResponseEntity.ok().body(new Response("Failed", 400, Id));
		}
	}

	@PutMapping("/trash/{Id}/{Token}")
	public ResponseEntity<Response> update(@Valid @PathVariable("Token") String token, @PathVariable("Id") long id) {
		boolean b = service.updateTrash(token, id);
		if (b) {
			return ResponseEntity.ok().body(new Response("updated", 200, id));

		} else {
			return ResponseEntity.ok().body(new Response("Update Failed", 400, id));
		}
	}

	@PutMapping("/colour/{Id}/{Token}")
	public ResponseEntity<Response> colourChange(@PathVariable("Token") String token, @PathVariable("Id") long id,
			@RequestHeader("colour") String colour) {
		System.out.println("Welcome");
		boolean b = service.colourChange(token, id, colour);
		if (b) {
			System.out.println("End");
			return ResponseEntity.ok().body(new Response("Colour Change Success ", 200, id));
			
		} else {
			System.out.println("end");
			return ResponseEntity.ok().body(new Response("Colour Change Failed", 400, id));
		}
	}
	
	@GetMapping("/getNotes/{Id}")
	public ResponseEntity<Response> getNotes(@Valid @RequestHeader("Token") String token,@PathVariable("Id") long id)
	{
		Notes b=service.getNotes(token,id);
		if(b!=null)
		{
			return ResponseEntity.ok().body(new Response("Success", 200,b));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,b));
		}
	}
	@GetMapping("/getAll/{token}")
	public ResponseEntity<Response> getall(@Valid @PathVariable("token") String token)
	{
		System.out.println("yes .....");
		List<Notes> n=service.getAll(token);
		if(n!=null)
		{
			return ResponseEntity.ok().body(new Response("Success",200,n));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400, n));
		}
	}
	
	@DeleteMapping("/deletnote/{Id}/{Token}")
	public ResponseEntity<Response> deletAll(@PathVariable("Token") String token,@PathVariable("Id") long id)
	{
		boolean b=service.delete(token,id);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Delete Success",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Delete Failed",400,""));
		}
	}
	@PutMapping("/reminder/{Id}/{Token}")
	public ResponseEntity<Response> reminder(@PathVariable("Token") String token,@PathVariable("Id") long id,@RequestHeader("reminder") String reminder)
	{
		boolean b=service.reminder(token,id,reminder);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Update Success",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Update Failed",400,""));
		}
	}
	
	@PutMapping("/addlabels/{id}/{idl}/{token}")
	public ResponseEntity<Response> addLabels(@PathVariable String token,@PathVariable long id,@PathVariable long idl)
	{
		boolean b=service.addlabels(token,id,idl);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Success",200,""));
		}
			
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,""));
		}
		
	}
	@PutMapping("/editNotes/{id}/{token}")
	public ResponseEntity<Response> edite(@PathVariable String token,@PathVariable long id,@RequestBody NoteEdite edite)
	{
		System.out.println(edite);
		boolean b=service.edite(token,id,edite);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Success",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,""));
		}
	}
	
	@PutMapping("editeText/{id}/{token}")
	public ResponseEntity<Response> editeText(@PathVariable String token,@PathVariable long id,@RequestBody Notes edite)
	{
		boolean b=service.editeText(token,id,edite);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Success",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("failed",400,""));
		}
	}
	
	
}
