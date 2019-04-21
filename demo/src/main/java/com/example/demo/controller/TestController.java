/**
 * @ClassName: TestController
 * @Description: TODO(概况)
 * @author: shic
 * @date: 2019-04-21 14:22
 */
package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public String test(){
        System.out.println("嘿嘿嘿");
        return "123";
    }
}
