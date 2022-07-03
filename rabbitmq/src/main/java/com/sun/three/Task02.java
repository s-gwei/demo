package com.sun.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.sun.utils.RabbitMQutils;

import java.util.Scanner;

/**
 * @author sungw
 * 消息被多个消费者消费时，当某个消费者中断，消息也不会丢失，
 * 会被其他消费者消费，这需要设置消费的应答方式为手动应答
 * @version 1.0
 * @date 2021/8/9 3:12 下午
 */
public class Task02 {
    private static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] argv) throws Exception {
        try (Channel channel = RabbitMQutils.getChannel()) {

            channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入信息");
            while (sc.hasNext()) {
                String message = sc.nextLine();
                //MessageProperties.PERSISTENT_TEXT_PLAIN发送消息为持久化消息，保存在磁盘上，
                channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
                System.out.println("生产者发出消息：" + message);
            }
        }
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        Channel channel = RabbitMQutils.getChannel();
        channel.queueDeclare(TASK_QUEUE_NAME, false, false, true, null);
        /**
         * 发送一个消息
         * 1.发送到那个交换机
         * 2.路由的 key 是哪个
         * 3.其他的参数信息
         * 4.发送消息的消息体
//         */
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//        System.out.println("消息发送完毕");
//        channel.basicConsume("", TASK_QUEUE_NAME, null,)
    }
}
