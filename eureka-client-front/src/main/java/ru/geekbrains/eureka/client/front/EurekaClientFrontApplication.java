package ru.geekbrains.eureka.client.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaClientFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFrontApplication.class, args);
    }

}
