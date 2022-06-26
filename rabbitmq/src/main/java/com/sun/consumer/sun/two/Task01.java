package com.sun.consumer.sun.two;

import com.rabbitmq.client.Channel;
import com.sun.consumer.sun.utils.RabbitMQutils;

import java.util.Scanner;

/**
 * @author sungw
 * @version 1.0
 * @date 2021/8/6 5:16 下午
 */
public class Task01 {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        try (Channel channel = RabbitMQutils.getChannel();) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //从控制台当中接受信息
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String message = scanner.next();
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println("发送消息完成:" + message);
            }
        }
    }
}
