package com.example.cinema.models.configuration;

import com.example.cinema.models.entities.Room;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public Room room() {
        return Room.getInstance();
    }
}
