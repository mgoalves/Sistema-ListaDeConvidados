package com.alves.lista.service;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.alves.lista.model.Convidado;

@Service
public class EmailService {

	public void enviarEmail(Convidado convidado) {

		try {

			Email email = new SimpleEmail();

			// Propriedades
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthentication("javaapplication.alves@gmail.com", "javaMail");
			email.setSSLOnConnect(true);

			// Destinatário
			email.setFrom("javaapplication.alves@gmail.com");
			email.setSubject("Nome na lista!");
			email.setMsg("Olá, " + convidado.getNome()
					+ " você colocou seu nome na lista vip! \n\n\nAtt,\nEquipe TomorrowLand.");
			email.addTo(convidado.getEmail());
			email.send();

		} catch (EmailException e) {

			e.printStackTrace();
		}

	}

}
