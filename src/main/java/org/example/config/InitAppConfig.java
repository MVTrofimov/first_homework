package org.example.config;

import org.example.InitRepository;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application_init.properties")
@Profile("init")
public class InitAppConfig {

    @Bean
    public InitRepository initRepository(){
        return new InitRepository();
    }

}
