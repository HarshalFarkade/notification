package com.obts.hrms.notification.notification.dto.request;

import java.time.LocalDate;

public class TemplateRequestDTO {
    private String templateName;
    private String templateSubject;
    private String templateBody;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;

    public TemplateRequestDTO() {
    }

    public TemplateRequestDTO(String templateName, String templateSubject, String templateBody, LocalDate startDate, LocalDate endDate, Boolean active) {
        this.templateName = templateName;
        this.templateSubject = templateSubject;
        this.templateBody = templateBody;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getTemplateSubject() {
        return templateSubject;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getActive() {
        return active;
    }
}
