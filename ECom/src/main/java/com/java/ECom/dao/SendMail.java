package com.java.ECom.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.cj.Session;

public class SendMail {

	public static void mailSend(String to, String subject, String msg) {
		
		String from = "ksstshivendra26@gmail.com";
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("ksstshivendra03@gmail.com", "soqdhechjkcchkgl");

            }
        });
        
        session.setDebug(true);
        
        try {
        
	        MimeMessage message = new MimeMessage(session);
	        
	        message.setFrom(new InternetAddress(from));
	        
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        
	        message.setSubject("This is the Subject Line!");
	        
	        message.setText("This is actual message");
	        
	        System.out.println("sending...");
	        
	        Transport.send(message);
	        System.out.println("Sent message successfully....");
	}catch(MessagingException mex) {
		mex.printStackTrace();
	}
}
