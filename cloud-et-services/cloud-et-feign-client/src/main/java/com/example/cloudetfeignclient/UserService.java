package com.example.cloudetfeignclient;

@FeignClient("user-service")
@RequestMapping("/user_sys/user")
public interface UserService {
    @GetMapping("/getUser")
    Result getUser(@RequestParam int id);

    @GetMapping("/addUser")
    Result addUser(@RequestParam("name") String name);

    @PostMapping("/add")
    Result addUser2(@RequestBody User user);
}
