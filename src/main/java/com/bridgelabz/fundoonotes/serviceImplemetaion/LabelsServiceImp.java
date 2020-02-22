package com.bridgelabz.fundoonotes.serviceImplemetaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Repository.NoteRepository;
import com.bridgelabz.fundoonotes.Repository.UserRepository;
import com.bridgelabz.fundoonotes.Repository.labelsRepository;
import com.bridgelabz.fundoonotes.dto.LabelDto;
import com.bridgelabz.fundoonotes.model.Labels;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.service.ServiceLabel;
import com.bridgelabz.fundoonotes.utility.Utility;

@Service
public class LabelsServiceImp implements ServiceLabel {
	@Autowired
	Utility util;
	@Autowired
	UserRepository userRep;
	@Autowired
	labelsRepository labels;
	@Autowired
	NoteRepository noteRep;

	@Override
	public boolean createLabels(LabelDto label, String token) {

		String s = util.MailDetails(token);
		User u = userRep.findOneByEmail(s);
//		Labels ll = labels.findByLabelid(id)(8);

		if (u != null) {
			Labels l = new Labels();
			l.setLabelTitle(label.getName());
			l.setUser(u);
			labels.save(l);
			return true;

		}
		return false;
	}

	@Override
	public boolean deletlabel(String token, long id) {
		String s = util.MailDetails(token);
		User u = userRep.findOneByEmail(s);
		Labels l = labels.findByLabelid(id);

		if (u != null && l != null) {
//			System.out.println("it is comming deletelabel");
////			labels.deleteById(id);
//			labels.deleteByUserAndLabelid(u, id);
//			System.out.println("completed");
			labels.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatelabels(String token, long id, LabelDto name) {
		String s = util.MailDetails(token);
		User u = userRep.findOneByEmail(s);
		Labels l = labels.findByLabelid(id);
		if (u != null && l != null) {
			l.setLabelTitle(name.getName());
			
			labels.save(l);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Labels> getAllLabels(String token) {
		String s = util.MailDetails(token);

		User u = userRep.findOneByEmail(s);
		 long id=u.getId();
		 
//		 List<Labels> ll=labels.
//		System.out.println(ll);

		if (u != null) {
			List<Labels> l=labels.findAllById(u);
			     
			System.out.println(l);
			return l;

		} else {
			return null;
		}
	}

	@Override
	public List<Notes> getAllNotes(String token, long idl) {
		String s = util.MailDetails(token);
		User u = userRep.findOneByEmail(s);
		Labels l = labels.findByLabelid(idl);

		if (u != null && l != null) {
			System.out.println(l.getNoteList());
			return l.getNoteList();

		} else {
			return null;
		}

	}

	@Override
	public boolean changeLabels(String token, long idl, long id) {
		String s = util.MailDetails(token);
		User u = userRep.findOneByEmail(s);
		Labels l = labels.findByLabelid(idl);
		Notes n = noteRep.findById(id);
		if (u != null && l != null && n != null) {
			
			n.getLabel().add(l);
			noteRep.save(n);
			return true;
		}
		return false;
	}

	@Override
	public boolean removelabel(String token, long idl, long id) {
		String s = util.MailDetails(token);
		User u = userRep.findOneByEmail(s);
		Labels l = labels.findByLabelid(idl);
		Notes n = noteRep.findById(id);
		if (u != null && l != null && n != null) {
			n.getLabel().remove(l);
			noteRep.save(n);
			return true;
		} else {
			return false;
		}
	}
}
