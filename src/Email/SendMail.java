package Email;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class SendMail {
	
	private final String username;
	private final String password; 
	private String to; 
	private String subject;
	private String email_body;
	private Properties props = new Properties();
	

	public SendMail( String to, String email_body, String subject){
		
			this.username = "isandu469@gmail.com";
			this.password = "!qwerty0";
			this.to = to;
			this.subject = subject;
			this.email_body = email_body;
			
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.socketFactory.port", "587");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.port", "587");

	        
	       
	    }
		public boolean send(){
				
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });
				
			 try {
		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(username));
		            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		            message.setSubject(subject);
		            message.setText(email_body);
		            Transport.send(message);
		            return true;
		           
		        } catch (Exception e) {
					System.out.println(e);
					return false;
		        }
		}
}
