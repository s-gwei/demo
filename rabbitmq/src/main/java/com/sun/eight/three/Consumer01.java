package com.sun.eight.three;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.sun.utils.RabbitMQutils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 消费者1
 * @author: sungw
 * @create: 2022-07-09 11:22
 **/
public class Consumer01 {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange1";
    //普通队列
    public static final String NORMAL_QUEUE = "normal_queue1";
    //死信交换机
    public static final String DEAD_EXCHANGE = "dead_exchange";
    //死信队列
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();

        //声明死信和普通交换机，类型为dirct
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE,BuiltinExchangeType.DIRECT);

        //声明queue的最后一个参数arguments
        Map<String, Object> arguments = new HashMap<>();
        //正常队列设置死信交换机
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", "lisi");
        //设置正常队列的长度的限制
        arguments.put("x-max-length", 100000);
        //设置过期时间,也可以生产者设置过期时间
//        arguments.put("x-message-ttl", 100000);


        //声明死信和普通队列,由最后一个参数决定普通队列是否发消息给死信交换机
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, arguments);
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);

        //交换机和队列绑定
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "zhangsan");
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "lisi");
        System.out.println("等待接收消息");



        //接收消息
        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println("consume01接受的消息是" + new String(message.getBody(), "UTF-8"));
        };

        //拒绝消息
        CancelCallback cancelCallback =(consumerTag)->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑");
        };

        channel.basicConsume(NORMAL_QUEUE, true, deliverCallback, cancelCallback);
    }


}
