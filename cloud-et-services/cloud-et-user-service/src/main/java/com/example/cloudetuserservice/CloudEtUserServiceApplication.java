package com.example.cloudetuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
public class CloudEtUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEtUserServiceApplication.class, args);
    }

}
