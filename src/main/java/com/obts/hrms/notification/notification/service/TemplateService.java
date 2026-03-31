package com.obts.hrms.notification.notification.service;

import com.obts.hrms.notification.notification.dto.request.TemplateRequestDTO;
import com.obts.hrms.notification.notification.dto.response.TemplateResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface TemplateService {
    TemplateResponseDTO createTemplate(TemplateRequestDTO request);
}
