package com.woody.controller;

import com.woody.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常处理前端控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("Executing...");

        // Exception
        try {
            int i = 5/0;
        } catch (Exception e) {
            e.printStackTrace();

            // 抛出自定义异常信息
            throw new SysException("查询所有用户出现错误...");
        }

        return "success";
    }
}
