package com.uber.email.service.core;

public record EmailRequest(String to, String subject, String body) {
}
