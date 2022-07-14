package com.sun.controller;

import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import javax.annotation.Resource;
import java.util.Date;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @description: 测试请求异步
 * @author: sungw
 * @create: 2022-07-13 18:30
 **/

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/createUser")
    public String createUser(){
        User user = new User();
        user.setId(1);
        user.setName("sungw");
        log.info("当前时间:{},创建一个user：{}",new Date().toString(),user);
        rabbitTemplate.convertAndSend("X","XA", "消息来自ttl为10s的队列:" + user);
        return "success";
    }
}
