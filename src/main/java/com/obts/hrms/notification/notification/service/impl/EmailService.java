package com.obts.hrms.notification.notification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

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

            if (subject == null || subject.isEmpty()) {
                subject = "Notification from HRMS";
            }

            MimeMessage message = mailSender.createMimeMessage();

            // ✅ UTF-8 fix
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            // ✅ Better from name
            helper.setFrom(fromMail, "OBTS HR Team");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // HTML

            mailSender.send(message);
           
            log.info("✅ Email sent successfully to: {}", to);

        } catch (Exception e) {
            log.error("❌ Email sending failed: ", e);
            throw new RuntimeException("Email sending failed: " + e.getMessage());
        }
    }
}