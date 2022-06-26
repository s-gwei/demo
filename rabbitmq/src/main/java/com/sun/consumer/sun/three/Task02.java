package com.sun.consumer.sun.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.sun.consumer.sun.utils.RabbitMQutils;

import java.util.Scanner;

/**
 * @author sungw
 * @version 1.0
 * @date 2021/8/9 3:12 下午
 */
public class Task02 {
    private static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] argv) throws Exception {
        try (Channel channel = RabbitMQutils.getChannel()) {
            //消息持久化
            boolean durable = true;
//            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入信息");
            while (sc.hasNext()) {
                String message = sc.nextLine();
                //MessageProperties.PERSISTENT_TEXT_PLAIN发送消息为持久化消息，保存在磁盘上，
                channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
                System.out.println("生产者发出消息：" + message);
            }
        }
    }
}
