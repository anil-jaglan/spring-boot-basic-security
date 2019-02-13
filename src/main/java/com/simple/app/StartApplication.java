package com.simple.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Starts the application.
 *
 */
@SpringBootApplication
@ComponentScan("com.simple")
public class StartApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
