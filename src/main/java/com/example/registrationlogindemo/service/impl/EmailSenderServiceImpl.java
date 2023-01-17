package com.example.registrationlogindemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,String subject,String body){
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setFrom("csovidiu1234@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);
        javaMailSender.send(mailMessage);
    }

}
