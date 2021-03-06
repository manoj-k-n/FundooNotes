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
import com.bridgelabz.fundoonotes.service.ElasticSerachService;
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
	
	@Autowired
	private ElasticSerachService elasticSerach;

	@Override
	public boolean creatnots(NoteDto note, String token) {

		String s = util.MailDetails(token);

		User u = userRepo.findOneByEmail(s);

		if (u != null) {
			Notes notes = new Notes();
			notes.setTitle((String) note.getTitle());
			notes.setTake_a_note((String) note.getTake_a_note());
			notes.setCreatDate(notes.getCreatDate());
			notes.setColour(note.getColour());
			notes.setUser(u);

			NotesRep.save(notes);
			System.out.println("notes details "+notes);
			if(notes!=null)
			{
				System.out.println("passing");
				elasticSerach.createNote(notes);
				return true;	
			}
			return false;
			
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
			n.setArchive(!n.isArchive());
			n.setPin_Note(false);
			n.setTrash(false);
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
			n.setPin_Note(!n.isPin_Note());
			n.setArchive(false);
			n.setTrash(false);
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
			n.setTrash(!n.isTrash());
			n.setArchive(false);
			n.setPin_Note(false);
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
			System.out.println("notes");
			System.out.println(l);
			return l;
		} else
			return null;
	}

	@Override
	public boolean delete(String token, long id) {
		String s = util.MailDetails(token);
		User u = userRepo.findOneByEmail(s);
		if (u != null) {
			System.out.println(id);
//			NotesRep.deleteById(id);
			Notes n=NotesRep.findById(id);
//			List<Notes> nn=NotesRep.findAll();
//			
//			for(Notes o:nn)
//			{
//				System.out.println("Notes" );
//				System.out.println(o);
//				System.out.println("Notes gon");
//			}
//			System.out.println(n);
			NotesRep.delete(n);
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
		Labels l = labels.findByLabelid(idl);
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
		
		 NotesRep.save(n);
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	}
	
	@Override
	public boolean editeText(String token, long idn, Notes edite) {
	String s=util.MailDetails(token);
	User u=userRepo.findOneByEmail(s);
	Notes n=NotesRep.findById(idn);
	if(u!=null&&n!=null)
	{
		n.setTitle((String) edite.getTitle());
		n.setTake_a_note((String) edite.getTake_a_note());
		NotesRep.save(n);
		return true;
	}
	else
	{
		return false;
	}
		
	}
}
