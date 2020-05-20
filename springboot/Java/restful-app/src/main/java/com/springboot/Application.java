package com.springboot;
//Application class sets up the Spring Boot application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //enables auto-configuration and component scanning
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
