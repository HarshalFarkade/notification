package com.obts.hrms.notification.notification.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "template_details", schema = "notification")
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String templateName;

    private String templateSubject;

    @Column(columnDefinition = "TEXT")
    private String templateBody;

    private LocalDate startDate;
    private LocalDate endDate;

    private Boolean active;
    private Boolean isDelete;

    public TemplateEntity() {
    }

    public TemplateEntity(Long id, String templateName, String templateSubject, String templateBody, LocalDate startDate, LocalDate endDate, Boolean active, Boolean isDelete) {
        this.id = id;
        this.templateName = templateName;
        this.templateSubject = templateSubject;
        this.templateBody = templateBody;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.isDelete = isDelete;
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

    public String getTemplateSubject() {
        return templateSubject;
    }

    public void setTemplateSubject(String templateSubject) {
        this.templateSubject = templateSubject;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    public void setTemplateBody(String templateBody) {
        this.templateBody = templateBody;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "TemplateEntity{" +
                "id=" + id +
                ", templateName='" + templateName + '\'' +
                ", templateSubject='" + templateSubject + '\'' +
                ", templateBody='" + templateBody + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                ", isDelete=" + isDelete +
                '}';
    }
}
