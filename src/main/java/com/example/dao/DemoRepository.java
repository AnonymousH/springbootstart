package com.example.dao;

import com.example.bean.SqlDemo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/5/9.
 *
 *   CrudRepository<SqlDemo, Long>   Long 是主键的类型
 *
 */
public interface  DemoRepository  extends CrudRepository<SqlDemo, Long> {

}
