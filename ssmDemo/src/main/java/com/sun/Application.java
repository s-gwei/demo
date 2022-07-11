package com.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot启动入口
 */

//@SpringBootApplication(scanBasePackages = {"com.sun.*"})
@SpringBootApplication(scanBasePackages = {"com.sun.*"})
@MapperScan("com.sun.dao")
public class Application  extends SpringBootServletInitializer{

    /**
     * 启动方法
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}



