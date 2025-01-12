package com.example.servis8;

public class Notification {

    // Ідентифікатор курсу
    private Long courseId;

    // Повідомлення для сповіщення
    private String message;

    // Конструктор для ініціалізації об'єкта Notification
    public Notification(Long courseId, String message) {
        this.courseId = courseId;
        this.message = message;
    }

    // Геттер для courseId
    public Long getCourseId() {
        return courseId;
    }

    // Сеттер для courseId
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    // Геттер для message
    public String getMessage() {
        return message;
    }

    // Сеттер для message
    public void setMessage(String message) {
        this.message = message;
    }
}
