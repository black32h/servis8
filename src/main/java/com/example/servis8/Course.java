package com.example.servis8;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

    // Визначення первинного ключа для сутності "Course"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Назва курсу
    private String description; // Опис курсу
    private String instructor; // Ім'я викладача

    // Геттер для поля "id"
    public Long getId() {
        return id;
    }

    // Сеттер для поля "id"
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для поля "name"
    public String getName() {
        return name;
    }

    // Сеттер для поля "name"
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для поля "description"
    public String getDescription() {
        return description;
    }

    // Сеттер для поля "description"
    public void setDescription(String description) {
        this.description = description;
    }

    // Геттер для поля "instructor"
    public String getInstructor() {
        return instructor;
    }

    // Сеттер для поля "instructor"
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
