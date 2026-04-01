package com.obts.hrms.notification.notification.dto.request;

import java.time.LocalDate;

public class TemplateRequestDTO {
    private String templateName;
    private String templateSubject;
    private String templateBody;


    public TemplateRequestDTO() {
    }

    public TemplateRequestDTO(String templateName, String templateSubject, String templateBody) {
        this.templateName = templateName;
        this.templateSubject = templateSubject;
        this.templateBody = templateBody;
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

}
