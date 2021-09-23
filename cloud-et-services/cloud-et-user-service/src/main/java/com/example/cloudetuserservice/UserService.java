package com.example.cloudetuserservice;

import com.example.cloudetbean.User;
import org.apache.tomcat.jni.Time;
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

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/getUser")
    public Result getUser(int id) throws InterruptedException {
        Thread.sleep(5000);
        Result<User> result = new Result<>();
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
