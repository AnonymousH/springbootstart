//package com.example.scheduling;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import static com.example.spider.Constant.testList;
//
///**
// * Created by Administrator on 2017/5/25.
// */
//
//@Configuration
//@EnableScheduling
//public class SchedulingTestA {
//
//    private int add = 0;
//
//    @Scheduled(cron = "0/3 * * * * ?") // 每5秒执行一次
//    public void scheduler() {
//        testList.add("this time add "+add);
//        add++;
//    }
//
//}
