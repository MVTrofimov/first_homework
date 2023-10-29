package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${spring.profiles.active}")
    String nameOfConfig;

    public String getNameOfConfig() {
        return nameOfConfig;
    }
}
