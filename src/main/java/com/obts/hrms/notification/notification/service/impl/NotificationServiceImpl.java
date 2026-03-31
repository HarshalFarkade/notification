package com.obts.hrms.notification.notification.service.impl;


import com.obts.hrms.notification.notification.dto.request.SendMailRequestDTO;
import com.obts.hrms.notification.notification.dto.response.SendMailResponseDTO;
import com.obts.hrms.notification.notification.entity.NotificationEntity;
import com.obts.hrms.notification.notification.entity.TemplateEntity;
import com.obts.hrms.notification.notification.repository.NotificationRepository;
import com.obts.hrms.notification.notification.repository.TemplateRepository;
import com.obts.hrms.notification.notification.service.NotificationService;
import com.obts.hrms.notification.notification.util.JsonUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final TemplateRepository templateRepository;
    private final NotificationRepository notificationRepository;

    private final EmailService emailService;
    private final JsonUtil jsonUtil;

    public NotificationServiceImpl(TemplateRepository templateRepository,
                                   NotificationRepository notificationRepository,

                                   EmailService emailService,
                                   JsonUtil jsonUtil) {
        this.templateRepository = templateRepository;
        this.notificationRepository = notificationRepository;

        this.emailService = emailService;
        this.jsonUtil = jsonUtil;
    }

    @Override
    public SendMailResponseDTO sendMail(SendMailRequestDTO request) {

        try {

            TemplateEntity template = templateRepository
                    .findByTemplateNameAndActiveTrueAndIsDeleteFalse(request.getMailTemplate())
                    .orElseThrow(() -> new RuntimeException("Template not found"));

            LocalDate today = LocalDate.now();
            if ((template.getStartDate() != null && today.isBefore(template.getStartDate())) ||
                    (template.getEndDate() != null && today.isAfter(template.getEndDate()))) {

                return new SendMailResponseDTO(false, "Template not active", null);
            }

            Map<String, Object> data = request.getMapToTemplate();



            NotificationEntity notification = new NotificationEntity();
            notification.setEmployeeId(request.getEmployeeId());
            notification.setToMail(request.getToMail());
            notification.setSubject(subject);
            notification.setMailTemplate(request.getMailTemplate());
            notification.setMapToTemplate(jsonUtil.toJson(data));
            notification.setCreatedAt(LocalDateTime.now());
            notification.setStatus("PENDING");

            notification = notificationRepository.save(notification);


            sendMailAsync(notification.getId(), request.getToMail(), subject, body);

            return new SendMailResponseDTO(true, "Email is being processed", notification.getId());

        } catch (Exception e) {
            return new SendMailResponseDTO(false, e.getMessage(), null);
        }
    }


    @Async
    public void sendMailAsync(Long notificationId, String to, String subject, String body) {

        NotificationEntity notification = notificationRepository.findById(notificationId).orElse(null);

        try {
            emailService.send(to, subject, body);

            if (notification != null) {


                notificationRepository.save(notification);
            }

        } catch (Exception e) {

            if (notification != null) {

                notificationRepository.save(notification);
            }
        }
    }
}