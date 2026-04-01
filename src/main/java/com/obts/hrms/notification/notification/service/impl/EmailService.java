package com.obts.hrms.notification.notification.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    public EmailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void send(String to, String subject, String body) {

        try {
            log.info("📧 Preparing email to: {}", to);

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(fromMail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            mailSender.send(message);

            log.info("✅ Email sent successfully to: {}", to);

        } catch (Exception e) {
            log.error("❌ Email sending failed: ", e);
            throw new RuntimeException("Email sending failed: " + e.getMessage());
        }
    }
}