package com.example.controller;

import com.example.bean.NewBean;
import com.example.bean.SqlDemo;
import com.example.bean.User;
import com.example.service.DemoService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
     *
     * @return
     */
    @RequestMapping("/save")
    public String save() {
        SqlDemo d = new SqlDemo();
        d.setName("Angel");
        demoService.save(d);//保存数据.
        return "ok.Demo2Controller.save";
    }

    @RequestMapping("/getById")
    public SqlDemo getById(long id) {

//        demoService.test();

        SqlDemo sqlDemo = demoService.getById(id);
        System.out.println("sqlDemo-->    " + sqlDemo);
        return sqlDemo;
    }


    @RequestMapping("/getNews")
    public List<NewBean> getNews(int pageNum, String name) {
        PageHelper.startPage(pageNum, 10);
        return demoService.getNews(name);
    }

    @RequestMapping("/getNew")
    public NewBean getNew(String name) {
        return demoService.getNew(name);
    }


    @RequestMapping("/test")
    public User putCache() {
        return demoService.findUser(1l, "wang", "yunfei");
    }

}
