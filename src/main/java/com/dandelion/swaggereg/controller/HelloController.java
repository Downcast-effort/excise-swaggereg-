package com.dandelion.swaggereg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghab
 * @date 2021/8/9
 * @description:
 **/
@RestController
public class HelloController {


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world!";
    }
}
