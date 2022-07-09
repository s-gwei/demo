package com.sun.eight.three;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.sun.utils.RabbitMQutils;

/**
 * @description: 消费者02
 * @author: sungw
 * @create: 2022-07-09 12:31
 **/
public class Consumer02 {
    //死信队列
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();
        //接收消息
        DeliverCallback deliverCallback = (consumerTag, message)->{
            System.out.println("consume02接受的消息是" + new String(message.getBody(), "UTF-8"));
        };

        //拒绝消息
        CancelCallback cancelCallback =(consumerTag)->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑");
        };

        channel.basicConsume(DEAD_QUEUE, true, deliverCallback, cancelCallback);
    }
}
