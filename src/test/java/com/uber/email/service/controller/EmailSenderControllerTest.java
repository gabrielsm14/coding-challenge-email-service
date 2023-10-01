package com.uber.email.service.controller;

import com.uber.email.service.application.EmailSenderService;
import com.uber.email.service.controllers.EmailSenderController;
import com.uber.email.service.core.EmailRequest;
import com.uber.email.service.core.exception.EmailServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmailSenderControllerTest {

    @InjectMocks
    private EmailSenderController emailSenderController;

    @Mock
    private EmailSenderService emailSenderService;

    @Mock
    private EmailRequest request;

    @Test
    void sendEmailSuccess() {
        EmailRequest emailRequest = getEmailRequest();

        doNothing().when(emailSenderService).sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());

        emailSenderController.sendEmail(emailRequest);

        verify(emailSenderService, times(1)).sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
    }

    @Test
    void sendEmailException() {
        EmailRequest emailRequest = getEmailRequest();

        doThrow(EmailServiceException.class).when(emailSenderService).sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());

        emailSenderController.sendEmail(emailRequest);
    }

    private static EmailRequest getEmailRequest() {
        return new EmailRequest("to", "subject", "body");
    }
}
