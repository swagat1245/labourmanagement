package com.labour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/index")
    public String user_dashboard(){
        return "normal/user_dashboard";
    }
}
