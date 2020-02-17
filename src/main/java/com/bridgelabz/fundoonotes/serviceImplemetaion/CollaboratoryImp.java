package com.bridgelabz.fundoonotes.serviceImplemetaion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Repository.CollaboratoreRepository;
import com.bridgelabz.fundoonotes.Repository.NoteRepository;
import com.bridgelabz.fundoonotes.Repository.UserRepository;
import com.bridgelabz.fundoonotes.dto.CollaboraterDto;
import com.bridgelabz.fundoonotes.model.Collaborater;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.service.ServiceCollaboratore;
import com.bridgelabz.fundoonotes.utility.Utility;

@Service
public class CollaboratoryImp implements ServiceCollaboratore {
	@Autowired
	private Utility util;
	@Autowired
	private UserRepository user;

	@Autowired
	private CollaboratoreRepository collaboRep;
	@Autowired
	private NoteRepository note;

	@Autowired
	private NotsServiceImp noteservice;
	
	@Override
	public boolean collaboratore(String token, long idn, CollaboraterDto email) {

		String s = util.MailDetails(token);
		User u = user.findOneByEmail(s);
		User u1 = user.findOneByEmail(email.getEmail());
//		System.out.println();
		Notes n = note.findById(idn);
		if (u != null && u1 != null && n != null) {
			Collaborater co = new Collaborater();
			co.setNotes(n);
			co.setEmail((String) email.getEmail());
			
//			noteservice.creatnots(n,)

			collaboRep.save(co);

			return true;
		} else {
			return false;
		}
	}
	@Override
	public boolean deletCollaborate(String token, long idc)
	{
	String s=util.MailDetails(token);
	User u=user.findOneByEmail(s);
	Collaborater c=collaboRep.findById(idc);
	System.out.println(c);
	if(u!=null&&c!=null)
	{
		collaboRep.deleteById(idc);
		
		return true;
	}
	else
	{
		return false;
	}
	}
	@Override
	public List<Collaborater> getAllCollaborate(String token, long idn) {
		String s=util.MailDetails(token);
		User u=user.findOneByEmail(s);
		Notes n=note.findById(idn);
		if(u!=null&&n!=null)
		{
			List<Collaborater> ll=new ArrayList<Collaborater>();
			long l=n.getId();
			for(Collaborater o:collaboRep.findAll())
			{
				if(l==(o.getNotes().getId()))
						{
					      ll.add(o);
						}
				
			}
			return ll;
			
		}
		else
		{
			return null;	
		}
				
		
	}
}
