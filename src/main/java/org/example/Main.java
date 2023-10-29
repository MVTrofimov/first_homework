package org.example;


import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Runner.class).start();
    }
}