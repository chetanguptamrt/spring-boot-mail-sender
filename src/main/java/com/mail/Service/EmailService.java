package com.mail.Service;

import org.springframework.stereotype.Service;

import com.mail.helper.Email;
import com.mail.model.MailDetail;

@Service
public class EmailService {

	public String sendMail(MailDetail mailDetail) {
		Thread thread = new Thread(new Email(mailDetail.getTomail(), mailDetail.getSubject(), mailDetail.getBody()));
		thread.start();
		return "done";
	}
	
}
