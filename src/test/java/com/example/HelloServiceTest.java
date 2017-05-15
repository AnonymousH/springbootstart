package com.example;

import com.example.bean.SqlDemo;
import com.example.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/15.
 */

//// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)

//// 指定我们SpringBoot工程的Application启动类
//@SpringApplicationConfiguration(classes = SpringbootstartApplication.class)
//上面的注解方式已经过时，改用 @SpringBootTest 即可
@SpringBootTest
///由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class HelloServiceTest {

    @Resource
    private DemoService helloService;

    @Test
    public void testGetName(){

        System.out.println(helloService.getById(1));
//        SqlDemo  sqlDemo =new SqlDemo();
//        sqlDemo.setId(1);
//        sqlDemo.setBirthDay(null);
//        sqlDemo.setName("Angel");

        Assert.assertEquals("Angel",helloService.getById(1).getName());
    }
}
