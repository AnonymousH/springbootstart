package com.example.mapper;

import com.example.bean.NewBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface DemoMapper {

    @Select("select *from new_bean where category = #{categery} ")
    List<NewBean> getNews(String categery);

    @Select("select *from new_bean where id = #{1} ")
    NewBean getNew(String categery);

}
