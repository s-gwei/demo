package com.sun.cluster;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: sungw
 * @create: 2022-07-12 18:18
 **/
@Component
public class MsgReceiver {

    @RabbitListener(queues = RabbitConfig.MY_QUEUE_NAME)
    public void handleMsg(String msg) {
        System.out.println("msg = " + msg);
    }
}
