package quartz;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobDemo implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		final String username = "willy741026@gmail.com";
		final String password = "";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", 587);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ritachang@egat.com.tw"));
			//willy741026@gmail.com
			//ritachang@egat.com.tw
			
			//�l��D���B�l�󤺮e
			message.setSubject("�C�L�q��");
			message.setText("\n�T�j�k�H�R�W����Ghttp://www.twse.com.tw/ch/trading/fund/T86/T86.php\n�T�j�k�H�R�W�g���Ghttp://www.twse.com.tw/ch/trading/fund/TWT54U/TWT54U.php\n��H�R��W�J�`��Ghttp://www.twse.com.tw/ch/trading/fund/TWT44U/TWT44U.php\n");

			Transport.send(message);
			System.out.println("Mail Send Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
