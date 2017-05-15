package com.example.controller;

import com.example.bean.Demo;
import com.example.bean.SqlDemo;
import com.example.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/9.
 */
@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

    @Resource
    private DemoService demoService;

    /**
     * 测试保存数据方法.
     * @return
     */
    @RequestMapping("/save")
    public String save(){
        SqlDemo d = new SqlDemo();
        d.setName("Angel");
        demoService.save(d);//保存数据.
        return"ok.Demo2Controller.save";
    }

    @RequestMapping("/getById")
    public SqlDemo getById(long id){
        return demoService.getById(id);
    }

}
