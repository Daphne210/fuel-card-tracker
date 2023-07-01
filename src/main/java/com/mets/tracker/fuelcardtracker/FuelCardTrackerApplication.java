package com.mets.tracker.fuelcardtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FuelCardTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuelCardTrackerApplication.class, args);
    }

}
