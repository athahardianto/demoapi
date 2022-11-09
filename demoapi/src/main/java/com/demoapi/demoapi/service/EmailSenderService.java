package com.demoapi.demoapi.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.demoapi.demoapi.model.dto.request.EmailSenderDto;

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

    public EmailSenderDto mimeMessageEmail(EmailSenderDto emailSenderDto) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailSenderDto.getSendTo());
            helper.setSubject(emailSenderDto.getSubject());
            String content = "<span>"+"<b>Dear "+emailSenderDto.getBody()+"</b><br>"
            +"<p>Assalamualaikum Warahmatullahi Wabarokatuh</p>"
            +"<p>Dengan izin Allah SWT Kami mengundang saudara pada acara pernikahan kami</p>"
            +"<b>Lorem dan Ipsum</b>"
            +"<br><img src='cid:image001'/><br><b>Terimakasih</b>"
            +"</span>";
            helper.setText(content, true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(emailSenderDto.getAttachment()));
            // helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            helper.addInline("image001", fileSystemResource);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send email");
        }
        return emailSenderDto;
    }
}
