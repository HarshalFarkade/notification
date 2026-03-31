package com.obts.hrms.notification.notification.dto.response;

public class SendMailResponseDTO {

    private boolean success;
    private String message;
    private Long notificationId;

    public SendMailResponseDTO(boolean success, String message, Long notificationId) {
        this.success = success;
        this.message = message;
        this.notificationId = notificationId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }
}