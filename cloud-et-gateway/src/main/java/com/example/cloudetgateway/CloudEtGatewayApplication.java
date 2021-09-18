package com.example.cloudetgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudEtGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEtGatewayApplication.class);
    }
}
