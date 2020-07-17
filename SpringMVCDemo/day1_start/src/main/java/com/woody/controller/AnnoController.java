package com.woody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 常用注解的示例类
 */
@Controller
@RequestMapping("/annotation")
public class AnnoController {

    @RequestMapping("/requestParam")
    public String testRequestParam(@RequestParam(value = "name")String testName,
                                   @RequestParam(value = "id", required = false) Integer testId) {
        System.out.println(testName + " " + testId);
        return "success";
    }

    @RequestMapping("/requestBody")
    public String testRequestBody(@RequestBody(required = false) String body) {
        System.out.println(body);
        return "success";
    }
}
