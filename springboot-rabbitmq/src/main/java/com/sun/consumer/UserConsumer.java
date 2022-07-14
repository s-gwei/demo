package com.sun.consumer;

import com.rabbitmq.client.Channel;
import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @author: sungw
 * @create: 2022-07-13 18:39
 **/
@Component
@Slf4j
public class UserConsumer {

    @RabbitListener(queues = {"delayed.queue"})
    public void receiveMsg(Message message, Channel channel){
        String msg = new String(message.getBody());
        log.info("当前时间为{}，收到延迟消息为{}",new Date(), msg);
    }
}
