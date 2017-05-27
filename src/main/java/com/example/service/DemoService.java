package com.example.service;

import com.example.bean.NewBean;
import com.example.bean.SqlDemo;
import com.example.bean.User;
import com.example.dao.DemoDao;
import com.example.dao.DemoRepository;
import com.example.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    public void save(SqlDemo demo) {
        demoRepository.save(demo);
    }


    @Resource
    private RedisTemplate<String,String> redisTemplate;

    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }

        @Cacheable(value="demoInfo") //缓存,这里没有指定key.
//    @Cacheable(value = "addresscache", keyGenerator = "wiselyKeyGenerator")
    public SqlDemo getById(long id) {
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        System.err.println("=========从数据库中进行获取的....id=" + id);
        return demoDao.getById(id);
//        return new SqlDemo(id,"","");
    }


    public List<NewBean> getNews(String name) {
        List<NewBean> newBeans = demoMapper.getNews(name);
        return newBeans;
    }

    public NewBean getNew(String name) {
        NewBean newBean = demoMapper.getNew(name);
        return newBean;
    }

    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public User findUser(Long id,String firstName,String lastName){
        System.out.println("无缓存的时候调用这里");
        return new User(id,firstName,lastName);
    }

}
