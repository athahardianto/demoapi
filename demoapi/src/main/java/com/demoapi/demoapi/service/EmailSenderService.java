package com.demoapi.demoapi.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailSenderService {
    private JavaMailSender mailSender;

    public EmailSenderDto sendSimpleEmail(EmailSenderDto emailSenderDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailSenderDto.getSendTo());
        message.setSubject(emailSenderDto.getSubject());
        message.setText(emailSenderDto.getBody());
        System.out.println("Simple Mail Send .........");
        mailSender.send(message);
        return emailSenderDto;
    }
}
