package com.sun.controller;

import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: user controller
 * @author: sungw
 * @create: 2022-07-14 17:52
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/get")
    public String getUser(){
        String message = "hello world";
        log.info("当前时间:{},发送一条消息给两个TTL队列：{}",new Date().toString(),message);
        rabbitTemplate.convertAndSend("xExchange","xRoutingKey", message);
        return message;
    }
}
