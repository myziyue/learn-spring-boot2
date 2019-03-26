package com.myziyue.learn.ch02.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping("/say.html")
    @ResponseBody
    public String say(String name) {
        return "Hello Spring Boot";
    }
}
