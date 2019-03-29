package com.myziyue.learn.ch03.mvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.myziyue.learn.ch03.mvc.entity.User;
import com.myziyue.learn.ch03.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: JSON控制器<br>
 * 描述: 日期转化需要参考JacksonConfig类<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/json")
public class JsonController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}.json")
    @ResponseBody
    public User showUserInfo(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/now.json")
    @ResponseBody
    public Map datetime() {
        //JacksonConfig 配置了序列化日期
        Map map = new HashMap(16);
        map.put("time", new Date());
        return map;
    }

    /**
     * 比如:json/date.json?date=2017-09-20 21:30:15
     *
     * @param date
     * @return
     */
    @GetMapping("/date.json")
    @ResponseBody
    public Map datetime(Date date) {
        //MvcConfigurer 配置了处理查询参数到日期类型的映射
        Map map = new HashMap(16);
        map.put("time", date);
        return map;
    }

}
