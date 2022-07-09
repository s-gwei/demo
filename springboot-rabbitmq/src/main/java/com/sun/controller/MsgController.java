package com.sun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 发送延时消息
 * @author: sungw
 * @create: 2022-07-09 14:49
 **/
@RestController
@RequestMapping("/ttl")
@Slf4j
public class MsgController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**但是队列的消息过期时间已经确定，10s,或者40s*/
    @GetMapping("/sendMsg/{message}")
    public void message(@PathVariable String message){
        log.info("当前时间:{},发送一条消息给两个TTL队列：{}",new Date().toString(),message);
        rabbitTemplate.convertAndSend("X","XA", "消息来自ttl为10s的队列:" + message);
        rabbitTemplate.convertAndSend("X","XB", "消息来自ttl为40s的队列:" + message);
    }

    /**开始发定义有过期时间的消息
     * 但是你会发现，设置过期时间较短的消息，会在先发的过期时间较长的消息被死信队列消费后，才会被消费，
     * 这与我们设置的时间长短不符合，因为rabbitmq只会检查第一个消息是否过期，这是一个巨大的缺陷
     * 只能通过插件解决*/
    @GetMapping("/sendMsg/{msg}/{ttlTime}")
    public void sendExpireMsg(@PathVariable("msg")String msg,@PathVariable("ttlTime")String ttlTime){
        /**后者会给占位符赋值，实现动态传递*/
        log.info("当前时间:{},发送一条时长是{}ms的TTL消息给QC队列,内容是{}",new Date(),ttlTime,msg);
        rabbitTemplate.convertAndSend("X","XC", "ttl消息为"+ ttlTime +"的时间，内容为:" + msg,message ->{
            /**生产者设置过期时间*/
            message.getMessageProperties().setExpiration(ttlTime);
            return message;
        });
    }
}
