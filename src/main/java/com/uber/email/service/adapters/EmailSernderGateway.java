package com.uber.email.service.adapters;

public interface EmailSernderGateway {

    void sendEmail(String to, String subject, String body);
}
