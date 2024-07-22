package br.com.cotiinformatica.mail;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailService {

	// parametros para envio de email                                    
	private static final String CONTA = "heitor.testeti@gmail.com";      
	private static final String SENHA = "clcjqvnpusbewuff";              
	private static final String SMTP  = "smtp.gmail.com";                
	private static final Integer PORTA = 465;                            

	public static void enviarMensagem(final String email, final String assunto, final String corpo) throws Exception{

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


		mailSender.setHost(SMTP);
		mailSender.setPort(PORTA);
		mailSender.setUsername(CONTA);
		mailSender.setPassword(SENHA);

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.smtp.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");
		
		
		
		

		//teste
		//javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		//javaMailProperties.put("mail.smtp.host", "smtp.gmail.com");


		//javaMailProperties.put("mail.smtp.starttls.required", "true");
		//javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		//properies.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		
		mailSender.setJavaMailProperties(javaMailProperties);

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

				message.setTo(email);
				message.setFrom(CONTA);				
				message.setSubject(assunto);
				message.setText(corpo);

			}
		};

		mailSender.send(preparator);
	}
}
