package com.bridgelabz.fundoonotes.serviceImplemetaion;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Repository.NoteRepository;
import com.bridgelabz.fundoonotes.Repository.UserRepository;
import com.bridgelabz.fundoonotes.Repository.labelsRepository;
import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.NoteEdite;
import com.bridgelabz.fundoonotes.model.Labels;
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

	@Autowired
	private labelsRepository labels;

	@Override
	public boolean creatnots(NoteDto note, String token) {

		String s = util.MailDetails(token);

		User u = userRepo.findOneByEmail(s);

		if (u != null) {
			Notes notes = new Notes();
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
		User u = userRepo.findOneByEmail(s);
		Notes n = NotesRep.findById(id);
		if (n != null & u != null) {
			n.setArchive(true);
			n.setUpdateDate(n.getUpdateDate());
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePin(long id, @Valid String token) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		Notes n = NotesRep.findById(id);
		if (n != null && u != null) {
			n.setPin_Note(true);
			n.setUpdateDate(n.getUpdateDate());
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateTrash(@Valid String token, long id) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		Notes n = NotesRep.findById(id);
		if (n != null & u != null) {
			n.setTrash(true);
			n.setUpdateDate(n.getUpdateDate());
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean colourChange(String token, long id, String colour) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		Notes n = NotesRep.findById(id);
		if (u != null && n != null) {
			n.setColour(colour);
			n.setUpdateDate(n.getUpdateDate());
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Notes getNotes(String token, long id) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		if (u != null) {
			Notes n = NotesRep.findById(id);
			return n;
		} else {
			return null;
		}

	}

	@Override
	public List<Notes> getAll(String token) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		if (u != null) {
			List<Notes> l = NotesRep.findAll();
			return l;
		} else
			return null;
	}

	@Override
	public boolean delete(String token, long id) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		if (u != null) {
			NotesRep.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean reminder(String token, long id, String reminder) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		Notes n = NotesRep.findById(id);
		if (u != null && n != null) {
			n.setLocalReminderStatus(reminder);
			n.setUpdateDate(n.getUpdateDate());
			n.setReminderDate(n.getReminderDate());
			NotesRep.save(n);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean addlabels(String token, long id, long idl) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		Notes n = NotesRep.findById(id);
		Labels l = labels.findById(idl);
		if (u != null && n != null && l != null) {
//			n.getLabel().add(l);
			n.getLabel().add(l);
			NotesRep.save(n);
			return true;
		}
		return false;
	}
	@Override
	public boolean edite(String token, long id, NoteEdite edite)
	{
	 String s=util.MailDetails(token);
	 User u=userRepo.findOneByEmail(s);
	 Notes n=NotesRep.findById(id);
	 if(u!=null&&n!=null)
	 {
		 n.setTitle(edite.getTitle());
		 n.setTake_a_note(edite.getTake_a_note());
		 n.setArchive(edite.isArchive());
		 n.setColour(edite.getColour());
		 n.setPin_Note(edite.isPin_note());
		 n.setTrash(edite.isTransh());
		 NotesRep.save(n);
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	}
}
