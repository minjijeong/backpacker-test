package com.api.backpackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BackpackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackpackerApiApplication.class, args);
    }

}
