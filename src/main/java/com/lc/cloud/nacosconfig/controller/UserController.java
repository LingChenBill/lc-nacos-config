package com.lc.cloud.nacosconfig.controller;

import com.lc.cloud.nacosconfig.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lingchen
 * @date: 2020/12/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/info")
    public String getUserInfo() {
        return "Nacos config's user: " + String.format("name : %s, age : %s", user.getName(), user.getAge());
    }
}
