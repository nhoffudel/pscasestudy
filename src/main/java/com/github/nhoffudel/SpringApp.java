package com.github.nhoffudel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) {
        JdbcConfigurator.initialize();
        SpringApplication.run(SpringApp.class, args);
    }
}
