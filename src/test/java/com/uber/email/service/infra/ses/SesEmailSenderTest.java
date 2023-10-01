package com.uber.email.service.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SesEmailSenderTest {

    @InjectMocks
    private SesEmailSender sesEmailSender;

    @Mock
    private AmazonSimpleEmailService amazonSimpleEmailService;

    @Test
    void sendEmailWithSuccess() {
        String to = "to";
        String subject = "subject";
        String body = "body";

        SendEmailRequest request = getRequest(to, subject, body);
        sesEmailSender.sendEmail(to, subject, body);

        verify(amazonSimpleEmailService, times(1)).sendEmail(request);

    }

    private static SendEmailRequest getRequest(String to, String subject, String body) {
        return new SendEmailRequest()
                .withSource("gabriel.mendonca1422@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));
    }
}
