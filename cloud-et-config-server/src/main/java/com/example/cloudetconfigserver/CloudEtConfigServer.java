package com.example.cloudetconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudEtConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(CloudEtConfigServer.class);
    }
}
