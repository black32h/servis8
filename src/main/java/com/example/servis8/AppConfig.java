package com.example.servis8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Створення біну RestTemplate для використання в інших компонентах
    @Bean
    public RestTemplate restTemplate() {
        // Повертаємо новий екземпляр RestTemplate для використання в сервісах
        return new RestTemplate();
    }
}
