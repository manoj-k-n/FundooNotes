package com.bridgelabz.fundoonotes.serviceImplemetaion;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Repository.NoteRepository;
import com.bridgelabz.fundoonotes.Repository.UserRepository;
import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.service.ServiceNotes;
import com.bridgelabz.fundoonotes.utility.Utility;

@Service
public class NotsServiceImp implements ServiceNotes {
	@Autowired
	private NoteRepository NotesRep;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private Utility util;

	Notes notes = new Notes();

	@Override
	public boolean creatnots(NoteDto note, String token) {

		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);

		if (u != null) {
			notes.setTitle((String) note.getTitle());
			notes.setTake_a_note((String) note.getTake_a_note());
			notes.setCreatDate(notes.getCreatDate());
			notes.setUser(u);

			NotesRep.save(notes);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateArchive(long id, @Valid String token) {
		String s = util.MailDetails(token);
		Notes n = NotesRep.findById(id);
		if (n != null) {
			n.setArchive(true);
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePin(long id, @Valid String token) {
		String s = util.MailDetails(token);
		Notes n = NotesRep.findById(id);
		if (n != null) {
			n.setPin_Note(true);
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateTrash(@Valid String token, long id) {
		String s = util.MailDetails(token);
		Notes n = NotesRep.findById(id);
		if (n != null) {
			n.setTrash(true);
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean colourChange(String token, long id, String colour) {
		String s = util.MailDetails(token);
		Notes n = NotesRep.findById(id);
		if (n != null) {
			n.setColour(colour);
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Notes getNotes(@Valid String token, long id) 
	{
	return NotesRep.findAllById(id));
	}
}
