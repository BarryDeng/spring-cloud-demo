package com.example.cloudetuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(bacePackages = "com.example.mapper")
@EnableCircuitBreaker
public class CloudEtUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEtUserServiceApplication.class, args);
    }

}
