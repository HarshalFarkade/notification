package com.obts.hrms.notification.notification.dto.request;

import java.util.Map;

public class SendMailRequestDTO {
    private String employeeId;
    private String toMail;
    private String subject;
    private Map<String, Object> mapToTemplate;
    private String mailTemplate;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Object> getMapToTemplate() {
        return mapToTemplate;
    }

    public void setMapToTemplate(Map<String, Object> mapToTemplate) {
        this.mapToTemplate = mapToTemplate;
    }

    public String getMailTemplate() {
        return mailTemplate;
    }

    public void setMailTemplate(String mailTemplate) {
        this.mailTemplate = mailTemplate;
    }
}
