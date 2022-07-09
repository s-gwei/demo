package com.sun.one;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.sun.utils.RabbitMQutils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @description: 优先级队列
 * 是实时的，当有消息进来，都会将消息排序，所以，有可能造成消息积压
 * @author: sungw
 * @create: 2022-07-09 18:04
 **/
public class Product01 {

    public static final String QUEUE = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();


        HashMap<String, Object> arugments = new HashMap<>();
        arugments.put("x-max-priority", 10);
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        channel.queueDeclare(QUEUE, false, false, false, arugments);

        String message = "你好，世界";

        /**
         * 发送一个消息
         * 1.发送到那个交换机
         * 2.路由的 key 是哪个
         * 3.其他的参数信息
         * 4.发送消息的消息体
         */
        for(int i=0; i<100000; i++){
            if(i%5 == 0){
                AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().priority(5).build();
                channel.basicPublish("",QUEUE, properties, (message+i).getBytes(StandardCharsets.UTF_8));
            }else{
                channel.basicPublish("",QUEUE, null, (message+i).getBytes(StandardCharsets.UTF_8));
            }
        }

    }
}
