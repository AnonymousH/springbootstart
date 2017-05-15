package com.example.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Administrator on 2017/5/9.
 *
 *  定时任务
 */

@Configuration
@EnableScheduling
public class SchedulingConfig {

//    @Scheduled(cron = "0/5 * * * * ?") // 每20秒执行一次
//    public void scheduler() {
//        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
//    }

}
