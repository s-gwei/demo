package com.sun.three.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.sun.utils.RabbitMQutils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description: 消息在rabbitmq中持久化,保证rabbitmq在崩溃时，消息不丢失
 * @author: sungw
 * @create: 2022-07-02 15:47
 **/
public class Task02 {
    private static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        //队列持久化
        boolean durable = true;
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, true, null);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入信息");
        while (sc.hasNext()) {
            String message = sc.nextLine();
            /**
             * 发送一个消息
             * 1.发送到那个交换机
             * 2.路由的 key 是哪个
             * 3.其他的参数信息
             * 4.发送消息的消息体
              */

            //durable是队列持久化参数，MessageProperties.PERSISTENT_TEXT_PLAIN是消息持久化参数，两者不能混为一谈，
            //MessageProperties.PERSISTENT_TEXT_PLAIN可以使消息保存在磁盘上，而不是内存中
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }
    }
}
