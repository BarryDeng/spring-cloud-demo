package com.example.cloudetfeignclient;

import com.example.cloudetbean.Result;
import com.example.cloudetbean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class CloudEtFeignClientApplication {

    @Resource
    private UserService userService;

    @NewSpan
    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @NewSpan
    @GetMapping("/postkv")
    public Result<User> postkv(User user) {
        return userService.addUser(user.getName(),
                user.getEmail(),
                user.getAge());
    }

    @NewSpan
    @GetMapping("postjson")
    public Result<User> postjson(User user) {
        return userService.addUser2(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudEtFeignClientApplication.class, args);
    }
}
