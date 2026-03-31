package com.obts.hrms.notification.notification.service;

import com.obts.hrms.notification.notification.entity.NotificationEntity;
import com.obts.hrms.notification.notification.repository.NotificationRepository;
import com.obts.hrms.notification.notification.service.impl.EmailService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncEmailService {
    private final EmailService emailService;
    private final NotificationRepository notificationRepository;

    public AsyncEmailService(EmailService emailService,
                             NotificationRepository notificationRepository) {
        this.emailService = emailService;
        this.notificationRepository = notificationRepository;
    }

    @Async
    public void sendMailAsync(Long notificationId, String to, String subject, String body) {

        NotificationEntity notification = notificationRepository
                .findById(notificationId)
                .orElse(null);

        try {
            // ✅ Send mail
            emailService.send(to, subject, body);

            if (notification != null) {
                // (Optional)
                // notification.setStatus("SUCCESS");
                notificationRepository.save(notification);
            }

        } catch (Exception e) {

            if (notification != null) {
                // notification.setStatus("FAILED");
                notificationRepository.save(notification);
            }

            System.out.println("Email failed: " + e.getMessage());
        }
    }
}
