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
//@Configuration
//@EnableScheduling
//public class ScheudlingTestB {
//
//
//    @Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
//    public void scheduler() {
//        System.out.println("-->  "+testList.get(0));
//        testList.remove(0);
//        System.out.println("-->  "+testList.toString());
//
//    }
//
//}
