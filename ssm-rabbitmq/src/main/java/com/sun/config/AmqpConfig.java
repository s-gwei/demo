package com.sun.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @description: 发送对象消息
 * @author: sungw
 * @create: 2022-07-15 15:58
 **/
@Configuration
@EnableRabbit
public class AmqpConfig {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Bean
    public AmqpTemplate amqpTemplate(){
        //使用jackson消息对象装换器，发送对象的时候才开启
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        rabbitTemplate.setMandatory(true);
        return rabbitTemplate;
    }
}
