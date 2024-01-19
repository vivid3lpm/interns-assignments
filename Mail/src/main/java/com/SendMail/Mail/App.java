package com.SendMail.Mail;
import jakarta.mail.Session;
import jakarta.mail.PasswordAuthentication;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import java.io.File;
import java.util.Properties;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class App 
{
	 public static void main(String[] args) {
	        // Replace with your actual email details
	        final String from = "iamvivekprajapati@gmail.com";
	        String to = "hr@ignitershub.com";
	        String host = "smtp.gmail.com"; // SMTP server address
	        final String password = "password";
	        String imagePath = "C:\\img.jpg";

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", true);
	        props.put("mail.smtp.starttls.enable", true); // Enable TLS for security
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", "587"); // Typical SMTP port

	        Session session = Session.getInstance(props, new Authenticator() {
	        	    
	                    protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(from, password);
	                    }
	                });

	        try {
	        	MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(to));
	            message.setSubject("Challenge 3 Completed");

	            // Create the message body
	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            messageBodyPart.setText("Name : Vivek Kumar ,\nInstitute : CDAC,Noida ,\nBranch : PG-DAC ,\nRoll No,:230320520142");

	            // Create a multi-part message
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(messageBodyPart);

	            // Add the image attachment
	            MimeBodyPart imagePart = new MimeBodyPart();
	            DataSource dataSource = new FileDataSource(imagePath);
	            imagePart.setDataHandler(new DataHandler(dataSource));

	            // Validate image type
	            String imageType = dataSource.getContentType();
	            if (!imageType.startsWith("image/png") && !imageType.startsWith("image/jpeg") && !imageType.startsWith("image/jpg")) {
	                throw new MessagingException("Invalid image type. Only PNG, JPG, and JPEG are allowed.");
	            }


	            imagePart.setFileName(new File(imagePath).getName());
	            multipart.addBodyPart(imagePart);

	            // Set the multi-part message as email content
	            message.setContent(multipart);

	            Transport.send(message);
	            System.out.println("Email sent successfully!");
	        } catch (MessagingException e) {
	            throw new RuntimeException(e); // Handle errors appropriately
	        }
	    }
}
