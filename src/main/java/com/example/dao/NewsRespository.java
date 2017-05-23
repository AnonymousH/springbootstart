package com.example.dao;

import com.example.bean.NewBean;
import com.example.spider.NewsSpide;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface NewsRespository extends CrudRepository<NewBean, String> {
}
