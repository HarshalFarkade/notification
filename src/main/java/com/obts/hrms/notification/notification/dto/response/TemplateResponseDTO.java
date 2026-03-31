package com.obts.hrms.notification.notification.dto.response;

public class TemplateResponseDTO {
    private Long id;
    private String templateName;
    private String message;

    public TemplateResponseDTO(Long id, String templateName, String message) {
        this.id = id;
        this.templateName = templateName;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
