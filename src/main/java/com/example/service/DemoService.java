package com.example.service;

import com.example.bean.NewBean;
import com.example.bean.SqlDemo;
import com.example.dao.DemoDao;
import com.example.dao.DemoRepository;
import com.example.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

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


    public List<NewBean> getNews(String name){
        List<NewBean> newBeans = demoMapper.getNews(name);
        return newBeans;
    }

   public NewBean getNew(String name){
       NewBean newBean =demoMapper.getNew(name);
        return newBean;
    }

}
