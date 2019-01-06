package com.demo2.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2018/12/10.
 */
@RestController
public class TestController {
    @RequestMapping("/Hello")
    public String helloworld(){
        return "Hello World";
    }
}
