package com.obts.hrms.notification.notification.service;

import com.obts.hrms.notification.notification.dto.request.SendMailRequestDTO;
import com.obts.hrms.notification.notification.dto.response.SendMailResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

	public SendMailResponseDTO sendMail(SendMailRequestDTO request);
}
