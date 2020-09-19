import java.util.Properties;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import java.util.Properties;



public class sendEmail {
	
	final static String senderEmailId="amruta131192@gmail.com";
	final static String senderPass="108108108";
	final static String emailSmtpServer="smtp.gmail.com";
	final static String emailServerPort="465";
	
	public static void sendemail(String eml,int randomno)
	{
		System.out.println("hi");
		Properties properties=new Properties();
		properties.put("mail.smtp.user", senderEmailId);
		properties.put("mail.smtp.host",emailSmtpServer);
		properties.put("mail.smtp.port",emailServerPort);
		
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.socketFactory.port",emailServerPort);
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		properties.put("mail.smtp.socketFactory.fallback","false");
		
		
		javax.mail.Session session=javax.mail.Session.getDefaultInstance(properties,new javax.mail.Authenticator()
				{
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
					{
				return new javax.mail.PasswordAuthentication(senderEmailId,senderPass);
				}
	});
		 try
		 {
			 javax.mail.Message message=new MimeMessage(session);
			 message.setFrom(new InternetAddress(senderEmailId));
			 message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(eml));
			 message.setSubject("Email verification code");
			 message.setText("your OTP is"+randomno);
			 Transport.send(message);
			 System.out.println("message sent successfully");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println("error in try");
				}
		
		
		
	}

}

