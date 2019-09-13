package com.kanasuki.nadbank.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Main {

    public static void main(String[] argv) {
        SpringApplication.run(Main.class, argv);
    }
}
