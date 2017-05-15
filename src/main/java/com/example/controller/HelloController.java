package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/9.
 */

@RestController  // 标记为：restful
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return"Hello world!";
    }

}
