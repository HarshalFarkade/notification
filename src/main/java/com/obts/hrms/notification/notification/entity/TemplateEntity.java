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


    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive=true ;
    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete=false;

    public TemplateEntity() {
    }

    public TemplateEntity(Long id, String templateName, String templateSubject, String templateBody, LocalDate createdAt, LocalDate updatedAt, Boolean isActive, Boolean isDelete) {
        this.id = id;
        this.templateName = templateName;
        this.templateSubject = templateSubject;
        this.templateBody = templateBody;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isActive=" + isActive +
                ", isDelete=" + isDelete +
                '}';
    }
}
