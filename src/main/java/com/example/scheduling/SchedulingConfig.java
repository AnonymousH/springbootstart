package com.example.scheduling;

import com.example.bean.NewBean;
import com.example.service.SaveNewsService;
import com.example.spider.NewsSpide;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 *
 *  定时任务
 */

@Configuration
@EnableScheduling
public class SchedulingConfig {


    @Resource
    private  SaveNewsService saveNewsService;

    private int cstart =0;
    private int cend =9;

    private long id = 1495527701094L;

    @Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
    public void scheduler() {


        List<NewBean> newBeans = NewsSpide.connectUrl(cstart,cend,id);

        System.out.println("scheduler() return -->   "+newBeans.size());


        for (int i = 0; i < newBeans.size(); i++) {
            saveNewsService.save(newBeans.get(i));
        }

        id++;
        cstart +=10;
        cend +=10;

    }

}
