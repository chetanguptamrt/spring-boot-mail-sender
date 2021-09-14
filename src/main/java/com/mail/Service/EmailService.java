package com.mail.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.model.MailDetail;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender emailSender;

	public String sendMail(MailDetail mailDetail) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@baeldung.com");
        message.setTo(mailDetail.getTomail()); 
        message.setSubject(mailDetail.getSubject()); 
        message.setText(mailDetail.getBody());
        emailSender.send(message);
		return "done";
	}
	
}
