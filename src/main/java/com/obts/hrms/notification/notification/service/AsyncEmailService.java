package com.obts.hrms.notification.notification.service;

import com.obts.hrms.notification.notification.entity.NotificationEntity;
import com.obts.hrms.notification.notification.repository.NotificationRepository;
import com.obts.hrms.notification.notification.service.impl.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncEmailService {

    private static final Logger log = LoggerFactory.getLogger(AsyncEmailService.class);

    private final EmailService emailService;
    private final NotificationRepository notificationRepository;

    public AsyncEmailService(EmailService emailService,
                             NotificationRepository notificationRepository) {
        this.emailService = emailService;
        this.notificationRepository = notificationRepository;
    }

    @Async
    public void sendMailAsync(Long notificationId, String to, String subject, String body) {

        log.info("🚀 Async email triggered for notificationId: {}", notificationId);

        NotificationEntity notification = notificationRepository
                .findById(notificationId)
                .orElse(null);

        try {
            emailService.send(to, subject, body);

            if (notification != null) {
                // Optional: add status column
                // notification.setStatus("SUCCESS");
                notificationRepository.save(notification);
            }

            log.info("✅ Async email success for ID: {}", notificationId);

        } catch (Exception e) {

            log.error("❌ Async email failed for ID: {}", notificationId, e);

            if (notification != null) {
                // notification.setStatus("FAILED");
                notificationRepository.save(notification);
            }
        }
    }
}