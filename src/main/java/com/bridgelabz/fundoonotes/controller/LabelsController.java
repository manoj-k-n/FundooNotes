package com.bridgelabz.fundoonotes.controller;

import java.util.List;

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

import com.bridgelabz.fundoonotes.dto.LabelDto;
import com.bridgelabz.fundoonotes.model.Labels;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.ServiceLabel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LabelsController 
{   
	@Autowired
    private ServiceLabel service;
	@PostMapping("/labels/{token}")
	public ResponseEntity<Response> createLabels(@RequestBody LabelDto label,@PathVariable String token)
	{
		boolean b=service.createLabels(label,token);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Successfull",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,""));
		}
	}
	@DeleteMapping("/deletelabel/{id}/{token}")
	public ResponseEntity<Response> deletlabel(@PathVariable String token,@PathVariable long id)
	{
		boolean b=service.deletlabel(token,id);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Successfull",200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,""));
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updatelabele(@RequestHeader String token,@PathVariable long id,@RequestBody LabelDto name)
	{
		boolean b=service.updatelabels(token,id,name);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Successfull", 200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,""));
		}
	}
	
	@GetMapping("/getall/{token}")
	public ResponseEntity<Response> getAlllabels(@PathVariable String token)
	{
		List<Labels> b=service.getAllLabels(token);
		if(b!=null)
		{
			return ResponseEntity.ok().body(new Response("Successfull",200,b));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed", 400,null));
		}
	}
	@GetMapping("/getAllNotes/{idl}")
	public ResponseEntity<Response> getAllNotes(@RequestHeader String token,@PathVariable long idl)
	{
		List<Notes> b=service.getAllNotes(token,idl);
		if(b!=null)
		{
			return ResponseEntity.ok().body(new Response("Successfull",200,b));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,null));
		}
	}
	@PutMapping("/changelabel/{idl}/{id}")
	public ResponseEntity<Response> changelabels(@RequestHeader String token,@PathVariable long idl,@PathVariable long id)
	{
		boolean b=service.changeLabels(token,idl,id);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Successfull", 200, ""));
		}
		return ResponseEntity.ok().body(new Response("Failed", 400, null));
	}
	
	@PutMapping("/removelabel/{idl}/{id}")
	public ResponseEntity<Response> removeLabel(@RequestHeader String token,@PathVariable long idl,@PathVariable long id)
	{
		boolean b=service.removelabel(token,idl,id);
		if(b)
		{
			return ResponseEntity.ok().body(new Response("Successfull", 200,""));
		}
		else
		{
			return ResponseEntity.ok().body(new Response("Failed",400,""));
		}
	}
}
