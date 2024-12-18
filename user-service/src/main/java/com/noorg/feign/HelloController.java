package com.noorg.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class HelloController {

    @GetMapping
    public String feign() {
        return "UserService HelloController,Hello!";
    }
}
