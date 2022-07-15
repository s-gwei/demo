package com.sun.consumer;

import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 接收对象消息
 * @author: sungw
 * @create: 2022-07-15 16:06
 **/

@Component
@Slf4j
@RabbitListener(queues = {"xQueue"})
public class TestConsumer {

    @RabbitHandler
    public void process(User user){
        log.info("当前时间为{}，收到延迟消息为{}", new Date(), user);
    }
}
