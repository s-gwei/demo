package com.sun.eight.one;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.sun.utils.RabbitMQutils;

/**
 * @description: 生产者01
 * @author: sungw
 * @create: 2022-07-09 11:59
 * 操作说明：先启动消费者01，生成各种交换机和队列的绑定关系，关闭消费者01，模拟消费者死亡，这样在规定时间内消息无法被消费，就会进入死信队列，被消费者02消费
 * 这里我觉得可以使用手动应答的方式，不需要关闭消费者01
 **/
public class Producer01 {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange";

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
