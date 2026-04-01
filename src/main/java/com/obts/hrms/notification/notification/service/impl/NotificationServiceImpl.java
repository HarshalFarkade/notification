package com.obts.hrms.notification.notification.service.impl;


import com.obts.hrms.notification.notification.dto.request.SendMailRequestDTO;
import com.obts.hrms.notification.notification.dto.response.SendMailResponseDTO;
import com.obts.hrms.notification.notification.entity.NotificationEntity;
import com.obts.hrms.notification.notification.entity.TemplateEntity;
import com.obts.hrms.notification.notification.repository.NotificationRepository;
import com.obts.hrms.notification.notification.repository.TemplateRepository;
import com.obts.hrms.notification.notification.service.AsyncEmailService;
import com.obts.hrms.notification.notification.service.NotificationService;
import com.obts.hrms.notification.notification.util.JsonUtil;
import com.obts.hrms.notification.notification.util.TemplateProcessor;
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
    private final TemplateProcessor templateProcessor;
    private final AsyncEmailService asyncEmailService;

    public NotificationServiceImpl(TemplateRepository templateRepository,
                                   NotificationRepository notificationRepository,
                                   EmailService emailService,
                                   JsonUtil jsonUtil,
                                   TemplateProcessor templateProcessor,
                                   AsyncEmailService asyncEmailService) {
        this.templateRepository = templateRepository;
        this.notificationRepository = notificationRepository;
        this.emailService = emailService;
        this.jsonUtil = jsonUtil;
        this.templateProcessor = templateProcessor;
        this.asyncEmailService=asyncEmailService;
    }

    @Override
    public SendMailResponseDTO sendMail(SendMailRequestDTO request) {

        try {

            TemplateEntity template = templateRepository
                    .findByTemplateNameAndIsActiveTrueAndIsDeleteFalse(request.getMailTemplate())
                    .orElseThrow(() -> new RuntimeException("Template not found or inactive"));

            Map<String, Object> data = request.getMapToTemplate();

            String subject = request.getSubject() != null
                    ? request.getSubject()
                    : templateProcessor.process(template.getTemplateSubject(), data);

            String body = templateProcessor.process(template.getTemplateBody(), data);

            NotificationEntity notification = new NotificationEntity();
            notification.setEmployeeId(request.getEmployeeId());
            notification.setToMail(request.getToMail());
            notification.setSubject(subject);
            notification.setMailTemplate(request.getMailTemplate());
            notification.setMapToTemplate(jsonUtil.toJson(data));
            notification.setCreatedAt(LocalDate.now());

            notification = notificationRepository.save(notification);

            asyncEmailService.sendMailAsync(
                    notification.getId(),
                    request.getToMail(),
                    subject,
                    body
            );

            return new SendMailResponseDTO(true, "Email sent Successfully", notification.getId());

        } catch (Exception e) {
            return new SendMailResponseDTO(false, e.getMessage(), null);
        }
    }


}