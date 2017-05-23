package com.example.service;

import com.example.bean.NewBean;
import com.example.dao.NewsRespository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/5/23.
 */
@Service
public class SaveNewsService {
    @Resource
    private NewsRespository newsRespository;

    @Transactional
    public void save(NewBean newBean){
        newsRespository.save(newBean);
    }
}
