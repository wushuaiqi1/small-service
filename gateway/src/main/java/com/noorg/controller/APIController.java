package com.noorg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hi")
public class APIController {


    @GetMapping("hey")
    public String hi(){
        return "hi";
    }
}
