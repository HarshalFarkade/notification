package com.obts.hrms.notification.notification.controller;

import com.obts.hrms.notification.notification.dto.request.SendMailRequestDTO;
import com.obts.hrms.notification.notification.dto.response.SendMailResponseDTO;
import com.obts.hrms.notification.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendMail")
    public ResponseEntity<SendMailResponseDTO> sendMail(@RequestBody SendMailRequestDTO request) {
        return ResponseEntity.ok(notificationService.sendMail(request));
    }
}
