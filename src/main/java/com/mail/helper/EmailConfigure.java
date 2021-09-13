package com.mail.helper;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailConfigure {
	
    private static Session session;
    private final static String fromEmail = "*************@gmail.com";
    private final static String password = "*************";
 
    public static Session getSession(){
        if(session==null){
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            session = Session.getDefaultInstance(props, auth);
            System.out.println("Session created");
        }
        return session;
    }
	
    
    
}
