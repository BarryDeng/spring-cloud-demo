package com.example.cloudetresttemplateclient;

import com.example.cloudetbean.Result;
import com.example.cloudetbean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CloudEtResttemplateClientApplication {

    @Autowired
    RestTemplate restTemplate;

    private static final String USER_SERVICE_URL = "http://user-service/user_sys";

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable int id) {
        String url = USER_SERVICE_URL + "/user/getUser?id=" + id;
        return restTemplate.getForObject(url, Result.class);
    }

    @GetMapping("/postjson")
    public Result postJson(User user) {
        String url = USER_SERVICE_URL + "/user/add";
        return restTemplate.postForObject(url, user, Result.class);
    }

    @GetMapping("/postkv")
    public Result postkv(User user) {
        String url = USER_SERVICE_URL + "/user/addUser";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("name", user.getName());
        return restTemplate.postForObject(url, param, Result.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudEtResttemplateClientApplication.class, args);
    }

}
