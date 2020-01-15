package com.getitsolved.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloSpring {

    @RequestMapping("/hello")
    public String hello(){

        return "This is SpringBoot App";
    }
}
