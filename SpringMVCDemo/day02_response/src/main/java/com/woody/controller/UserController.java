package com.woody.controller;

import com.woody.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString Method is executing...");

        User user = new User();
        user.setUsername("Mei");
        user.setPassword(123);
        model.addAttribute("user", user);

        return "success";
    }
}
