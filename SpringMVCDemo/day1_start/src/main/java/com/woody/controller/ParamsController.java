package com.woody.controller;

import com.woody.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定的示例的控制类
 */
@Controller
@RequestMapping("/params")
public class ParamsController {

    @RequestMapping("/findById")
    public String findById(Integer accountId) {
        System.out.println("根据" + accountId + "查询用户...");
        return "success";
    }

    /**
     * 把请求参数封装到JavaBean的类中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("saving " + account);
        return "success";
    }
}
