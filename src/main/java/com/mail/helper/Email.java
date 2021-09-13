package com.mail.helper;

import java.io.UnsupportedEncodingException;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email implements Runnable {
	
	private final String toEmail;
    private final String body;
    private final String subject;
    
    public Email(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.body = body;
        this.subject = subject;
    }
    
	@Override
	public void run() {
		send();
    }
	
	public void send() {
		try {
	    	Session session = EmailConfigure.getSession();
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(toEmail, "Text Mail"));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
        }
        catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
	}
	
}