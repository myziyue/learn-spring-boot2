package com.myziyue.learn.ch01.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/say.html")
    public @ResponseBody String say() {
        return "Hello Spring Boot2!";
    }
}
