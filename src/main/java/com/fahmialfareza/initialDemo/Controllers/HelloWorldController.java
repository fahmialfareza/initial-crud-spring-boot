package com.fahmialfareza.initialDemo.Controllers;

import com.fahmialfareza.initialDemo.Entity.UserName;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world/{name}")
    public String HelloWorldName(@PathVariable(value = "name") String name) {
        return "Hello, " + name;
    }

    @PostMapping("/hello-world")
    public String HelloWorldPost(@RequestParam(value = "UserName") String username) {
        return "Hello, " + username;
    }

    @PostMapping("/hello-world-user")
    public UserName HelloWorldUserPostController(@Valid @RequestBody UserName userName) {
        return userName;
    }
}
