package com.obts.hrms.notification.notification.service;

import com.obts.hrms.notification.notification.dto.request.TemplateRequestDTO;
import com.obts.hrms.notification.notification.dto.response.TemplateResponseDTO;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface TemplateService {
    TemplateResponseDTO createTemplate(TemplateRequestDTO request);
    String processTemplate(String templateName, Map<String, Object> data);

    String getSubject(String templateName, Map<String, Object> data);
}
