package com.example.dao;

import com.example.bean.SqlDemo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/9.
 *
 * 使用JdbcTemplate操作数据库.
 */
@Repository
public class DemoDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    /**
     * 通过id获取demo对象.
     * @param id
     * @return
     */
    public SqlDemo getById(long id){
        String sql = "select *from sql_demo where id=?";
        RowMapper<SqlDemo> rowMapper = new BeanPropertyRowMapper<SqlDemo>(SqlDemo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

}
