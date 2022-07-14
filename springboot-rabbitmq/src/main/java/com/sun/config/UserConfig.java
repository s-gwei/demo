package com.sun.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: user使用的交换机队列
 * @author: sungw
 * @create: 2022-07-13 18:44
 **/
@Configuration
public class UserConfig {

    /** user使用的交换机*/
    private static final String USER_EXCHANGE = "USER_EXCHANGE";

    /** user使用的队列*/
    private static final String USER_QUEUE = "USER_QUEUE";

    /**声明USER_EXCHANGE  别名*/
    @Bean("user_exchange")
    public DirectExchange userExchange(){
        return new DirectExchange(USER_EXCHANGE);
    }

    /**声明user队列*/
    @Bean("uesr_queue")
    public Queue userQueue(){
        return QueueBuilder.durable(USER_QUEUE).build();
    }

    /**队列和交换机绑定*/
    @Bean
    public Binding quserQueueBindingX(@Qualifier("uesr_queue") Queue userQueue,
                                  @Qualifier("user_exchange") Exchange userExchange){
        return BindingBuilder.bind(userQueue).to(userExchange).with("userA").noargs();
    }
}
