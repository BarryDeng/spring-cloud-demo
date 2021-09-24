package com.example.cloudetfeignclient;

import com.example.cloudetbean.Result;
import com.example.cloudetbean.User;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@Slf4j
public class CloudEtFeignClientApplication {

    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    @Bulkhead(name = "backendA", fallbackMethod = "fallbackMethod")
    public Result<User> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/postkv")
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackMethod")
    public Result<User> postkv(User user) {
        return userService.addUser(user.getName(),
                user.getEmail(),
                user.getAge());
    }

    @GetMapping("postjson")
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackMethod")
    public Result<User> postjson(User user) {
        return userService.addUser2(user);
    }

    public Result<User> fallbackMethod(Throwable throwable) {
        Result<User> result = new Result<>();
        result.setMsg("");
        result.setData(new User());
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudEtFeignClientApplication.class, args);
    }
}
