package com.sun.eight.four;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.sun.utils.RabbitMQutils;

/**
 * @description: 生产者01
 * @author: sungw
 * @create: 2022-07-09 11:59
 * 消息被拒绝
 **/
public class Producer01 {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange2";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();

        //死信消息，设置TTL时间
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();

        //该信息是用作演示队列个数限制
        for (int i = 1; i <11 ; i++) {
            String message="info"+i;
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", properties,
                    message.getBytes());
            System.out.println("生产者发送消息:"+message);
        }
    }
}
