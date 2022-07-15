package com.sun.controller;

import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 测试发送对象消息
 * @author: sungw
 * @create: 2022-07-15 16:03
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class TestController {


    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public String getUser(){
        Map<String, Object> msg = new HashMap<>(8);
        msg.put("type", "json");
        msg.put("version", 123);

        log.info("当前时间:{},发送一条消息给两个TTL队列：{}",new Date().toString(),msg.toString());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.convertAndSend("xExchange","xRoutingKey", msg);
        return msg.toString();
    }}
