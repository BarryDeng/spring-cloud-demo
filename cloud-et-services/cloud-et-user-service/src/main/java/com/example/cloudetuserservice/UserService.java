package com.example.cloudetuserservice;

import com.example.cloudetbean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cloudetbean.Result;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserService {

    @Value("${name}")
    private String name;

    @NewSpan
    @GetMapping("/getUser")
    public Result getUser(int id) {
        Result<User> result = new Result<User>();
        result.setCode(1);
        result.setMsg("abcdefg");
        User user = new User();
        user.setName(name);
        user.setAge(123);
        user.setEmail("abcd");
        result.setData(user);
        return result;
    }
}
