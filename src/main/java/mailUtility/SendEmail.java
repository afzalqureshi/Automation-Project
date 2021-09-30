package mailUtility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import commonUtility.CommonFunction;

public class SendEmail {
	
	
	
	
	public void sendAutomationEmail() 
	{
		try {
			//created object of properties class
			// and storing all connection related key value pair
			// ex: in which port my host is running and my host name
			Properties prop=new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "465");
			
			//this code will handle complete authentication
			
			final String username=CommonFunction.readPropertyFile("userEmail");
			final String password=CommonFunction.readPropertyFile("userPassword");
			Session session=Session.getDefaultInstance(prop,
					new javax.mail.Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(username, password);
				}
			});
		
			
			try {
				String receiverEmail=CommonFunction.readPropertyFile("receiverEmail");
				//you need to tell from which email id email will trigger
				Message message=new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
				String emailSubject=CommonFunction.readPropertyFile("emailSubject");
				message.setSubject(emailSubject);
				String emailBody=CommonFunction.readPropertyFile("emailBody");
				BodyPart part=new MimeBodyPart();
				part.setText(emailBody);
				
				MimeBodyPart attachment=new MimeBodyPart();
				
				String filename=System.getProperty("user.dir")+"\\AutomationReport\\";
				
				DataSource source=new FileDataSource(filename);
				attachment.setDataHandler(new DataHandler(source));
				attachment.setFileName(filename);
				
				//Create the object of MimeMultipart to add email body and attachment to email.
				Multipart multipart=new MimeMultipart();
				
				multipart.addBodyPart(part);
				multipart.addBodyPart(attachment);
				
				Transport.send(message);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
			
					
					
					
					
					
					
					
			

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
