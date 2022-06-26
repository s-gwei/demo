package com.sun.product;

import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.testng.annotations.Test;

/**
 * @author sungw
 * @version 1.0
 * @date 2021/8/6 9:33 上午
 */
@RunWith(SpringRunner.class)    // 固定写法
//@SpringBootTest(classes = RabbitMQApplication.class)// SpringBoot启动类（自定义的）
@SpringBootTest
public class RabTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;  // 注入一个RabbitMQ的模板对象，操作消息队列的对象

    // 发送一条点对点（Direct）的消息，又称为直连
//    @Test
    public void sendQueue(){
        System.out.println("开始向队列中发送一条消息！");
        // 参数1：管理中的队列名  参数2：发送的消息
        rabbitTemplate.convertAndSend("hello","message:这是一条消息！");
        System.out.println("消息发送完毕！");
    }
}
