package com.kanasuki.nadbank.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] argv) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CardRepository repository) {
        return args -> {
            repository.save(new Card("card1"));
            repository.save(new Card("card2"));
            repository.save(new Card("card3"));
            repository.save(new Card("card4"));
            repository.save(new Card("card5"));
            repository.save(new Card("card6"));
        };
    }
}
