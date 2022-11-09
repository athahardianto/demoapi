package com.demoapi.demoapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapi.demoapi.model.dto.request.EmailSenderDto;
import com.demoapi.demoapi.service.EmailSenderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {
    private EmailSenderService emailSenderService;

    @PostMapping
    public EmailSenderDto simpleMail(@RequestBody EmailSenderDto emailSenderDto){
        return emailSenderService.sendSimpleEmail(emailSenderDto);
    }

    @PostMapping("/attach")
    public EmailSenderDto mimeMessageMail(@RequestBody EmailSenderDto emailSenderDto) {
        return emailSenderService.mimeMessageEmail(emailSenderDto);
    }
}
