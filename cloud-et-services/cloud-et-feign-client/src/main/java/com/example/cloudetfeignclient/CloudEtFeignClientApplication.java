package com.example.cloudetfeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudEtFeignClientApplication {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudEtFeignClientApplication.class, args);
    }

}
