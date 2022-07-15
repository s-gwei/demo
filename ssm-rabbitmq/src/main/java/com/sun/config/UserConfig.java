package com.sun.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @description:
 * @author: sungw
 * @create: 2022-07-14 17:42
 **/
@Configuration
public class UserConfig {

    /**设置交换机*/
    private static final String X_EXCHANGE = "xExchange";

    /**设置队列*/
    private static final String X_QUEUE = "xQueue";

    /**声明交换机*/
    @Bean("xExchange")
    public DirectExchange xDirectExchange(){
        return new DirectExchange(X_EXCHANGE);
    }

    /** 声明队列*/
    /**声明xQueue*/
    @Bean("xQueue")
    public Queue xQueue(){
        return QueueBuilder.durable(X_QUEUE).build();
    }

    /**队列和交换机绑定*/
    @Bean
    public Binding queueBinding(@Qualifier("xQueue") Queue xQueue,
                                  @Qualifier("xExchange") Exchange xDirectExchange){
        return BindingBuilder.bind(xQueue).to(xDirectExchange).with("xRoutingKey").noargs();
    }


}
