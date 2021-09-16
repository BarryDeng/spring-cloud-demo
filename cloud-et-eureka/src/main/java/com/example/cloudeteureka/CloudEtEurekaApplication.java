package com.example.cloudeteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurakaServer
public class CloudEtEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEtEurekaApplication.class, args);
    }

}
