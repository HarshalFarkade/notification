package com.obts.hrms.notification.notification.controller;

import com.obts.hrms.notification.notification.dto.request.TemplateRequestDTO;
import com.obts.hrms.notification.notification.dto.response.TemplateResponseDTO;
import com.obts.hrms.notification.notification.service.TemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/template")
public class TemplateController {
    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }


    @PostMapping("/create")
    public ResponseEntity<TemplateResponseDTO> createTemplate(@RequestBody TemplateRequestDTO request) {
        return ResponseEntity.ok(templateService.createTemplate(request));
    }

}
