package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;

@RestController
@SpringBootApplication
@ServletComponentScan   //扫描到我们自己编写的servlet和filter
public class SpringbootstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstartApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("3MB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("30MB");
		//Sets the directory location where files will be stored.
		factory.setLocation("E:\\upload");
		return factory.createMultipartConfig();
	}

}
