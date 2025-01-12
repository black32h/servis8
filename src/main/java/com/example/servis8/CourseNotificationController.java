package com.example.servis8;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseNotificationController {

    // Оголошення сервісу для відправки сповіщень
    private final CourseNotificationService notificationService;

    // Конструктор, який приймає CourseNotificationService для інжекції залежності
    public CourseNotificationController(CourseNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Метод для обробки POST запиту на відправку сповіщення
    @PostMapping("/notifications")
    public ResponseEntity<Void> sendNotification(@RequestBody Notification notification) {
        // Викликаємо сервіс для надсилання сповіщення
        notificationService.sendCourseNotification(notification);
        // Повертаємо статус 200 OK після успішного виконання
        return ResponseEntity.ok().build();
    }
}
