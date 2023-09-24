package com.uber.email.service.core;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);

}
