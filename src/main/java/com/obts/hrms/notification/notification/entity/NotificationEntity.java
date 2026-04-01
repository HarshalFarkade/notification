package com.obts.hrms.notification.notification.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table( name = "notification_details",schema = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employeeId;

    private String toMail;
    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TEXT")
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String mapToTemplate;
    private String mailTemplate;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private String status;
    
    

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public NotificationEntity() {
    }

    public NotificationEntity(Long id, String employeeId, String toMail, String subject, String mapToTemplate, String mailTemplate, LocalDate createdAt, LocalDate updateAt,String body,String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.toMail = toMail;
        this.subject = subject;
        this.mapToTemplate = mapToTemplate;
        this.mailTemplate = mailTemplate;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.body=body;
        this.status=status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMapToTemplate() {
        return mapToTemplate;
    }

    public void setMapToTemplate(String mapToTemplate) {
        this.mapToTemplate = mapToTemplate;
    }

    public String getMailTemplate() {
        return mailTemplate;
    }

    public void setMailTemplate(String mailTemplate) {
        this.mailTemplate = mailTemplate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", toMail='" + toMail + '\'' +
                ", subject='" + subject + '\'' +
                ", mapToTemplate='" + mapToTemplate + '\'' +
                ", mailTemplate='" + mailTemplate + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }

}
