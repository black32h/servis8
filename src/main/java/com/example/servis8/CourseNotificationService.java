package com.example.servis8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseNotificationService {

    // Отримуємо значення URL сервісів з application.properties
    @Value("${course.service.url}")
    private String courseServiceUrl;

    @Value("${notification.service.url}")
    private String notificationServiceUrl;

    // Ініціалізація RestTemplate для виконання HTTP запитів
    private final RestTemplate restTemplate;

    // Конструктор для інжекції залежностей
    public CourseNotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Метод для відправки сповіщень студентам для активних курсів
    public List<String> sendNotifications() {
        // Список курсів, для яких були надіслані сповіщення
        List<String> notifiedCourses = new ArrayList<>();
        try {
            // Отримуємо список всіх курсів
            String coursesUrl = courseServiceUrl + "/courses";
            Course[] allCourses = restTemplate.getForObject(coursesUrl, Course[].class);

            // Якщо курси знайдені, перевіряємо кожен
            if (allCourses != null) {
                for (Course course : allCourses) {
                    // Перевіряємо наявність студентів для кожного курсу
                    String enrollmentUrl = courseServiceUrl + "/enrollments/courses/" + course.getId();
                    Long[] enrolledStudents = restTemplate.getForObject(enrollmentUrl, Long[].class);

                    // Якщо є студенти, надсилаємо сповіщення
                    if (enrolledStudents != null && enrolledStudents.length > 0) {
                        // Створюємо сповіщення
                        String notificationUrl = notificationServiceUrl + "/notifications";
                        Notification notification = new Notification(course.getId(), "Оновлення матеріалів курсу: " + course.getName());
                        restTemplate.postForObject(notificationUrl, notification, Void.class);
                        notifiedCourses.add(course.getName()); // Додаємо курс до списку надісланих сповіщень
                    }
                }
            }
        } catch (HttpClientErrorException e) {
            // Обробка помилок HTTP запитів (наприклад, якщо сервер не відповідає)
            System.out.println("Помилка: " + e.getMessage());
        }
        // Повертаємо список курсів, для яких було надіслано сповіщення
        return notifiedCourses;
    }

    // Метод для відправки сповіщення вручну (наприклад, через POST запит)
    public void sendCourseNotification(Notification notification) {
        // Логіка для надсилання сповіщень (поки що просто виводимо в консоль)
        System.out.println("Надсилаємо сповіщення для курсу: " + notification.getCourseId() + ", Повідомлення: " + notification.getMessage());
    }
}
