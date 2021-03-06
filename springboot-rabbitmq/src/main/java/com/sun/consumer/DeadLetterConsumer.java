package com.sun.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 消费消息
 * @author: sungw
 * @create: 2022-07-09 15:03
 **/
@Component
@Slf4j
public class DeadLetterConsumer {

    /**接收消息*/
    @RabbitListener(queues = {"QD"})
    public void receiveD(Message msg, Channel channel) throws Exception{
        String result = new String(msg.getBody());
        log.info("当前时间:{},收到死信队列的消息: {}",new Date().toString(),result);
    }
}
