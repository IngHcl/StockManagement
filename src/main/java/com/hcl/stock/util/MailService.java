package com.hcl.stock.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.hcl.stock.dto.EmailDto;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(EmailDto emailDto) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailDto.getEmailId());
		mail.setSubject(emailDto.getEmailSubject());

		mail.setText(emailDto.getTextBody());
		javaMailSender.send(mail);
	}

}
