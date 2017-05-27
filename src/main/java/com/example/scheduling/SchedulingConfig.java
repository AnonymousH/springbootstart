package com.example.scheduling;

import com.example.bean.NewBean;
import com.example.service.SaveNewsService;
import com.example.spider.NewsSpide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

import static com.example.spider.Constant.isNeedContinte;

/**
 * Created by Administrator on 2017/5/9.
 *
 *  定时任务
 */

@Configuration
@EnableScheduling
public class SchedulingConfig {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Resource
    private  SaveNewsService saveNewsService;

    private int cstart =0;
    private int cend =10;

//    private long id = 1495527701094L;
    private long id = 1495699255045L;      //1495700874352

    @Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
    public void scheduler() {

        if(isNeedContinte){
            id++;
            cstart +=10;
            cend +=10;

            List<NewBean> newBeans = NewsSpide.connectUrl(cstart,cend,id);

            System.out.println("scheduler() return -->   "+newBeans.size());

            if(newBeans.size()<=0){
                isNeedContinte = false;
                return;
            }

            for (int i = 0; i < newBeans.size(); i++) {
                try {
                    newBeans.get(i).setDislike_reason();
                    newBeans.get(i).setImage_urlss();
                    newBeans.get(i).setLikes();
                    saveNewsService.save(newBeans.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("------------------------ scheduler() for crash -------------------");
                }
            }

        }else{
//            System.out.println("------------------------ isNeedContinte  false-------------------" +isNeedContinte);
//            logger.debug("------------------------ debug------------------");
//            logger.info("------------------------ info------------------");
//            logger.error("------------------------ error------------------");
//            logger.warn("------------------------ warn------------------");
//            logger.trace("------------------------ trace------------------");

        }


    }

}
