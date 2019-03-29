package com.myziyue.learn.ch03.mvc.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class HelloworldController {
    @RequestMapping(value = "/index.html")
    public String say(Model model){
        model.addAttribute("name", "Hello World Spring Boot!");
        return "/index.btl"; // todo 特别注意，要以"/"开始
    }

    @GetMapping(path = "update2.json")
    @ResponseBody
    public String getUser(Integer id, String name) {
        return "Hi," + name + "(" + id + ") Success";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    // http://127.0.0.1:8088/test/date?d=2019-03-27
    @ResponseBody
    @RequestMapping("/date")
    public void printDate(Date d){
        System.out.println(d);
        return ;
    }
}
