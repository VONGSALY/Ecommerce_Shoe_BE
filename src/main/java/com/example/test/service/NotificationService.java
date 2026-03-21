package com.example.test.service;

import com.example.test.dto.notification.NotificationResponse;
import com.example.test.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> loadNotification(Boolean read, Boolean deliver);
    NotificationResponse modifyNotification(Long id);
    NotificationResponse updateNotification(Notification notification);
}
