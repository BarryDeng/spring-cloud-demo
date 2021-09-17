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

    @GetMapping("/postkv")
    public Result<User> postkv(User user) {
        return userService.addUser(user.getName(),
                user.getEmail(),
                user.getAge());
    }

    @GetMapping("postjson")
    public Result<User> postjson(User user) {
        return userService.addUser2(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudEtFeignClientApplication.class, args);
    }
}
