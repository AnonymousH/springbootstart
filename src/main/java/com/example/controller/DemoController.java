package com.example.controller;

import com.example.bean.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/9.
 */


@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("Angel");
        demo.setCode(1);
        return demo;
    }

    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100/0;
    }

}
