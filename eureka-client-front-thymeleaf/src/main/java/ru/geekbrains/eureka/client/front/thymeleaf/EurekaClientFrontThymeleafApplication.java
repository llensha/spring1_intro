package ru.geekbrains.eureka.client.front.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaClientFrontThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFrontThymeleafApplication.class, args);
    }

}
