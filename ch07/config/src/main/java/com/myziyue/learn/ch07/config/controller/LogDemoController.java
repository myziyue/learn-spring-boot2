package com.myziyue.learn.ch07.config.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class LogDemoController {
    private Log log = LogFactory.getLog(LogDemoController.class);
    @Autowired private Environment env;

    @RequestMapping("/say.html")
    @ResponseBody
    public String say(){
        log.debug(new LogDemoController());
        System.out.println(env.getProperty("user.dir"));
        System.out.println(env.getProperty("PATH"));
        return "Hello World!";
    }

    @RequestMapping("/showvalue.html")
    public @ResponseBody String value(@Value("${server.port}") int port) {

        return "Port: " + port;
    }
}
