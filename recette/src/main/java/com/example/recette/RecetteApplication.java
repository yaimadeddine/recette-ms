package com.example.recette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RecetteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecetteApplication.class, args);
    }


}
