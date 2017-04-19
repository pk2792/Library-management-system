package com.lms.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.sun.mail.smtp.SMTPTransport;

public class Email {
	
	public static void sendMail(String to, String mesg) throws AddressException, MessagingException{
//		 public static void main(String[] args) throws AddressException, MessagingException {
			 Properties props = System.getProperties();
		        props.put("mail.smtps.host","smtp.gmail.com");
		        props.put("mail.smtps.auth","true");
		        Session session = Session.getInstance(props, null);
		        Message msg = new MimeMessage(session);
		        msg.setFrom(new InternetAddress("pkaria@nyit.edu"));
		        
		        msg.setRecipients(Message.RecipientType.TO,
		        InternetAddress.parse(to, false));
		        
		        msg.setSubject("Registration Approved.");
		        msg.setText(mesg);
		        msg.setSentDate(new Date());
		        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
		        t.connect("smtp.gmail.com", "praptikaria27@gmail.com","mygmailnewpswd61932792");
		        try {
					t.sendMessage(msg, msg.getAllRecipients());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("Response: " + t.getLastServerResponse());
		        t.close();
		     
	}
}
//}
