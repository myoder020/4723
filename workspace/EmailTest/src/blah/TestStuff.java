package blah;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class TestStuff {
	public static void main(String []args) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("myoder020", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("myoder020@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.addTo("danielm8587@gmail.com");
		email.send();
	}
	
}
