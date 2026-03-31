package com.obts.hrms.notification.notification.service.impl;

import com.obts.hrms.notification.notification.dto.request.TemplateRequestDTO;
import com.obts.hrms.notification.notification.dto.response.TemplateResponseDTO;
import com.obts.hrms.notification.notification.entity.TemplateEntity;
import com.obts.hrms.notification.notification.repository.TemplateRepository;
import com.obts.hrms.notification.notification.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;


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
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setActive(request.getActive());
        entity.setDelete(false);

        TemplateEntity saved = templateRepository.save(entity);

        return new TemplateResponseDTO(saved.getId(), saved.getTemplateName(), "Template created successfully");
    }
}
