package com.myziyue.learn.ch03.mvc.controller;

import com.myziyue.learn.ch03.mvc.entity.User;
import com.myziyue.learn.ch03.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <br>
 * 标题: Freemaker控制器<br>
 * 描述: 使用Freemaker<br>
 *
 * @author zc
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/freemarker")
public class FreemakerController {

    @Autowired
    private UserService userService;

    /***
     * http://127.0.0.1:8080/freemarker//showuser.html?id=1
     * @param id
     * @return
     */
    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(Long id) {
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user", user);
        view.setViewName("/userInfo");
        return view;
    }

}
