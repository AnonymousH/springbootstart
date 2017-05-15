package com.example.service;

import com.example.bean.SqlDemo;
import com.example.dao.DemoDao;
import com.example.dao.DemoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/5/9.
 */
@Service
public class DemoService {

    @Resource
    private DemoRepository demoRepository;

    @Resource
    private DemoDao demoDao;

    @Transactional
    public void save(SqlDemo demo){
        demoRepository.save(demo);
    }

    public SqlDemo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        return demoDao.getById(id);
    }

}
