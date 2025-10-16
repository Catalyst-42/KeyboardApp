package ru.task8.layouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "ru.task8.layouts.client")
public class LayoutsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LayoutsApplication.class, args);
    }
}
