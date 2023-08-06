package com.example.cinema.models.configuration;

import java.util.UUID;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfiguration {
  @Component
  public static class TokenGenerator {
    public static String generateToken() {
      return UUID.randomUUID().toString();
    }
  }
}
