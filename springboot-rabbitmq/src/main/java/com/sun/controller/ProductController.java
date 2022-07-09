package com.sun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sungw
 * @create 2022/7/9 15:38
 * 发布确认高级
 */
@Slf4j
@RestController
@RequestMapping("/confirm")
public class ProductController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**发布确认高级*/
    private static final String CONFIRM_EXCHANGE_NAME = "confirm-exchange";
    private static final String CONFIRM_ROUTING_KEY = "confirm-key";

    @GetMapping("/sendConfirm/{msg}")
    public void sendConfirmMessage(@PathVariable("msg")String msg){
        /**声明回调的形参*/
        CorrelationData correlationData = new CorrelationData("1");
        rabbitTemplate.convertAndSend(CONFIRM_EXCHANGE_NAME, CONFIRM_ROUTING_KEY, msg,correlationData);
        log.info("发送信息为:" + msg);
    }
}
