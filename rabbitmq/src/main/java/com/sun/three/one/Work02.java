package com.sun.three.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.sun.utils.RabbitMQutils;

/**
 * @description: 消费持久化的消息
 * @author: sungw
 * @create: 2022-07-02 15:59
 **/
public class Work02 {

    private static final String ACK_QUEUE_NAME="ack_queue";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();

        //消息消费的时候，处理消息的回调方法
        DeliverCallback deliverCallback = (consumerTag, delivery)->{
            String messsage = new String(delivery.getBody());
            System.out.println("接收到消息："+messsage);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };

        //消息消费失败的回调函数
        CancelCallback cancelCallback = (consumerTag) ->{
            System.out.println(consumerTag+"消息者取消消费消息，的回调函数");
        };

        channel.basicConsume(ACK_QUEUE_NAME, false, deliverCallback, cancelCallback);
    }
}
