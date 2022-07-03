package com.sun.three.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.sun.utils.RabbitMQutils;
import com.sun.utils.SleepUtils;

/**
 * @description: 不公平分发，消息消息
 * @author: sungw
 * @create: 2022-07-02 16:56
 **/
public class Work04 {

    private static final String ACK_QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQutils.getChannel();
       /**
        * 不公平分发，
        * prefetCount为0时，是轮询分发，默认是轮询分发
        * 并且设置不公平分发时，必须每个消费者都是不公平分发，否者还是轮询分发
        * 设置不公平分发，应该是根据应答来确定消费消息是否完毕，所以必须设置手动应答，否者自动应该在接收到消息就应答，则没有意义
        *  预期值设置prefetCount为2时，就是预期值，就是设置消费者先接收多少条消息，设置为10
        */
        int prefetCount = 2;
        channel.basicQos(prefetCount);

        System.out.println("C1 等待接收消息处理时间较短");
        //消息消费的时候如何处理消息
        DeliverCallback deliverCallback=(consumerTag, delivery)->{
            String message= new String(delivery.getBody());
            SleepUtils.sleep(1);
            System.out.println("接收到消息:"+message);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };

        CancelCallback cancelCallback =(consumerTag)->{
            System.out.println(consumerTag+"消费者取消消费接口回调逻辑");
        };
        //1,采用手动应答
        boolean autoAck=false;
        channel.basicConsume(ACK_QUEUE_NAME,autoAck,deliverCallback,cancelCallback);
    }
}
