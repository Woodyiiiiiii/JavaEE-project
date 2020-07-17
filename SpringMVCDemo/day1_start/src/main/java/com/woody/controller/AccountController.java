package com.woody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping注解出现的位置
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/findAccount")
    public String findAccount() {
        System.out.println("查询了账户...");
        return "success";
    }
}
