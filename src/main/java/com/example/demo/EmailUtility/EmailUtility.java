package com.example.demo.EmailUtility;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {

	@Autowired
	//private JavaMailSender javaMailSender;
	private JavaMailSender javaMailSender;

	public Boolean sendEmail(String mailId,String Subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(mailId);
		msg.setSubject(Subject);
		msg.setText(body);
		javaMailSender.send(msg);
		return Boolean.TRUE;
	}
}
