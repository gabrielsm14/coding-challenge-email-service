package com.uber.email.service.application;

import com.uber.email.service.adapters.EmailSernderGateway;
import com.uber.email.service.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSernderGateway emailSernderGateway;

    @Autowired
     public EmailSenderService(EmailSernderGateway emailGateway) {
         this.emailSernderGateway = emailGateway;
     }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSernderGateway.sendEmail(to, subject, body);
    }
}
