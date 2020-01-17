package com.bridgelabz.fundoonotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.ServiceNotes;

@RestController
public class NoteController {
	@Autowired
	private ServiceNotes service;

	@PostMapping("/notes/{Token}")
	public ResponseEntity<Response> creatnots(@Valid @RequestBody NoteDto note, @PathVariable("Token") String Token) {

		boolean b = service.creatnots(note, Token);
		if (b) {
			return ResponseEntity.ok().body(new Response("Successfull", 200, ""));
		} else {
			return ResponseEntity.ok().body(new Response("Faild", 400, ""));
		}
	}

	@PutMapping("/archive/{Id}")
	public ResponseEntity<Response> updateAchive(@Valid @RequestHeader("token") String token,
			@PathVariable("Id") long Id) {

		boolean b = service.updateArchive(Id, token);
		if (b) {
			return ResponseEntity.ok().body(new Response("Successfull", 200, Id));
		} else {
			return ResponseEntity.ok().body(new Response("Faild", 400, Id));
		}
	}

	@PutMapping("pin/{Id}")
	public ResponseEntity<Response> updatePin(@Valid @RequestHeader("token") String token,
			@PathVariable("Id") long Id) {
		boolean b = service.updatePin(Id, token);
		if (b) {
			return ResponseEntity.ok().body(new Response("Successfull", 200, Id));
		} else {
			return ResponseEntity.ok().body(new Response("Faile", 400, Id));
		}
	}

	@PutMapping("trash/{Id}")
	public ResponseEntity<Response> update(@Valid @RequestHeader("Token") String token, @PathVariable("Id") long id) {
		boolean b = service.updateTrash(token, id);
		if (b) {
			return ResponseEntity.ok().body(new Response("updated", 200, id));

		} else {
			return ResponseEntity.ok().body(new Response("Update Fail", 400, id));
		}
	}

	@PutMapping("colour/{Id}")
	public ResponseEntity<Response> colourChange(@RequestHeader("token") String token, @PathVariable("Id") long id,
			@RequestHeader("colour") String colour) {
		System.out.println("Welcome");
		boolean b = service.colourChange(token, id, colour);
		if (b) {
			System.out.println("End");
			return ResponseEntity.ok().body(new Response("Colour Change Success ", 200, id));
			
		} else {
			System.out.println("end");
			return ResponseEntity.ok().body(new Response("Colour Change Faild", 400, id));
		}
	}
	
	@GetMapping("getNotes/{Id}")
	public ResponseEntity<Response> getNotes(@Valid @RequestHeader("token") String token,@PathVariable("Id") long id)
	{
		boolean b=service.getNotes(token,id);
	}
}
