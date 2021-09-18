package com.example.cloudetfeignclient;

import com.example.cloudetbean.Result;
import com.example.cloudetbean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
