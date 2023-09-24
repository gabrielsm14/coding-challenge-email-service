package com.uber.email.service.controller;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
