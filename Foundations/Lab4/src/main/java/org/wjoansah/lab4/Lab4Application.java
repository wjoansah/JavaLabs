package org.wjoansah.lab4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Lab4Application {

    @Value("${welcome.message}")
    private String welcomeMessage;

    private final Logger logger = LoggerFactory.getLogger(Lab4Application.class);

    @EventListener(ApplicationReadyEvent.class)
    public void LogWelcomeMessage() {
        logger.info(welcomeMessage);
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }
}
