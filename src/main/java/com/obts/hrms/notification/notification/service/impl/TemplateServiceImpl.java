package com.obts.hrms.notification.notification.service.impl;

import com.obts.hrms.notification.notification.dto.request.TemplateRequestDTO;
import com.obts.hrms.notification.notification.dto.response.TemplateResponseDTO;
import com.obts.hrms.notification.notification.entity.TemplateEntity;
import com.obts.hrms.notification.notification.repository.TemplateRepository;
import com.obts.hrms.notification.notification.service.TemplateService;
import com.obts.hrms.notification.notification.util.TemplateProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;
    private final TemplateProcessor templateProcessor;

    public TemplateServiceImpl(TemplateProcessor templateProcessor) {
        this.templateProcessor = templateProcessor;
    }


    @Override
    public TemplateResponseDTO createTemplate(TemplateRequestDTO request) {

        templateRepository.findByTemplateName(request.getTemplateName())
                .ifPresent(t -> {
                    throw new RuntimeException("Template already exists");
                });

        TemplateEntity entity = new TemplateEntity();
        entity.setTemplateName(request.getTemplateName());
        entity.setTemplateSubject(request.getTemplateSubject());
        entity.setTemplateBody(request.getTemplateBody());
        entity.setCreatedAt(LocalDate.now());
//        entity.setUpdatedAt(LocalDate.now());
        entity.setActive(true);   // default active
        entity.setDelete(false);  // default not deleted

        TemplateEntity saved = templateRepository.save(entity);

        return new TemplateResponseDTO(
                saved.getId(),
                saved.getTemplateName(),
                "Template created successfully"
        );
        
    }


    @Override
    public String processTemplate(String templateName, Map<String, Object> data) {

        TemplateEntity template = (TemplateEntity) templateRepository
                .findByTemplateName(templateName)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        return templateProcessor.process(template.getTemplateBody(), data);
    }

    @Override
    public String getSubject(String templateName, Map<String, Object> data) {

        TemplateEntity template = (TemplateEntity) templateRepository
                .findByTemplateName(templateName)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        return templateProcessor.process(template.getTemplateSubject(), data);
    }
}
