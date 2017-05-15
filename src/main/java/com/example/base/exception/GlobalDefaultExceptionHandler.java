package com.example.base.exception;

import com.example.bean.BaseJsonBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/9.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseJsonBean defaultErrorHandler(HttpServletRequest req, Exception e) {
        //打印异常信息：
        e.printStackTrace();
        System.out.println(e.toString());
        /*
        * 返回json数据或者String数据：
        * 那么需要在方法上加上注解：@ResponseBody
        * 添加return即可。
        */
        BaseJsonBean baseJsonBean =new BaseJsonBean();
        baseJsonBean.setCode(0);
        baseJsonBean.setMessage(e.getMessage());

        return baseJsonBean;

        /*
        * 返回视图：
        * 定义一个ModelAndView即可，
        * 然后return;
        * 定义视图文件(比如：error.html,error.ftl,error.jsp);
        *
        */

    }

}
