package com.github.fullcycle.catalog.admin.infrastructure;

import com.github.fullcycle.catalog.admin.application.UseCase;
import com.github.fullcycle.catalog.admin.infrastructure.configuration.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "production");
        SpringApplication.run(WebServerConfig.class, args);
    }
}
