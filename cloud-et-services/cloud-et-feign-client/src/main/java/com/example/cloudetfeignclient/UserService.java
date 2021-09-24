package com.example.cloudetfeignclient;

import com.example.cloudetbean.Result;
import com.example.cloudetbean.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@FeignClient("user-service")
@RequestMapping("/user_sys/user")
public interface UserService {
    @GetMapping("/getUser")
    Result<User> getUser(@RequestParam int id);

    @GetMapping("/addUser")
    Result<User> addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("age") int age);

    @PostMapping("/add")
    Result<User> addUser2(@RequestBody User user);

}
