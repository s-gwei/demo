package com.sun.eight.three;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.sun.utils.RabbitMQutils;

/**
 * @description: 生产者01
 * @author: sungw
 * @create: 2022-07-09 11:59
 * 操作说明：
 *  //死信消息，设置正常队列长度
 **/
public class Producer01 {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange1";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();


        //该信息是用作演示队列个数限制
        for (int i = 1; i <110000 ; i++) {
            String message="info"+i;
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, message.getBytes());
            System.out.println("生产者发送消息:"+message);
        }
    }
}
