package me.yekki.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaClient
@FeignClient
public class GUIApp {
    public static void main(String[] args) {
        SpringApplication.run(GUIApp.class, args);
    }
}
