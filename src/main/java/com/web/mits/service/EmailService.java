package com.web.mits.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailService {

	public static void sendEmail() throws MessagingException {

		 String username = "chithrabeeragownivari@gmail.com";
	        String password = "wwkl mrax ksql axdv";

	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("from@gmail.com"));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("bhagavancv@gmail.com"));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 message.setSubject("Thanks for registration with us!");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 String htmlMessage = "<h1>Hearthly Welcome!</h1>"
                 + "<p>Thank you for registering with our application. You can now login and start using our services.</p>"
                 + "<a href='https://www.yourapplicationurl.com'>Click here to login</a>";
     

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(htmlMessage, "text/html; charset=utf-8");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		

		message.setContent(multipart);

		Transport.send(message);

	}
}
