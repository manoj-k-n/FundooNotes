package com.bridgelabz.fundoonotes.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailVerification {
	@Autowired
	private JavaMailSender emailsender;

	public void sendVerificationMail(String mail, String token) {
		SimpleMailMessage msg = new SimpleMailMessage();
		System.out.println(mail);
		msg.setTo(mail);
		msg.setSubject("Verify user");
		msg.setText("click here:http://localhost:8080/users/verify/" + token);

		emailsender.send(msg);
		
	}

	public void sendpassword(String mail, String token) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setSubject("Forgot password");
		msg.setTo(mail);
		msg.setText("Click here:http://localhost:8080/users/resetpassword/" + token);

		emailsender.send(msg);
	}
}
