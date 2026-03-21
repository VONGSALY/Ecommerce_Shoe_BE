package com.example.test.controller;

import lombok.AllArgsConstructor;
import com.example.test.dto.notification.NotificationResponse;
import com.example.test.entity.Notification;
import com.example.test.repository.NotificationRepository;
import com.example.test.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
@CrossOrigin
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationRepository notificationRepository;

    @GetMapping("/load")
    public List<NotificationResponse> loadNotification() {
        return notificationService.loadNotification(false, true);
    }

    @GetMapping("/read")
    public NotificationResponse readNotification(@RequestParam("id") Long id) {
        return notificationService.modifyNotification(id);
    }

    @GetMapping("/push")
    public ResponseEntity<?> pushNotification() {
        // lấy ra cac thông báo sau khi dặt hàng, set deliver => true dể cho load lấy ra nhằm xác dinh thong báo da dc gửi tới admin
        List<Notification> notifications = notificationRepository.getNotificationByReadEqualsAndDeliverEquals(false, false);
        for (Notification n : notifications) {
            n.setDeliver(true);
            notificationService.updateNotification(n);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
