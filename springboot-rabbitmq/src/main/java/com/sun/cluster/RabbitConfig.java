package com.sun.cluster;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description:
 * @author: sungw
 * @create: 2022-07-12 18:11
 **/
@Configuration
public class RabbitConfig {
    public static final String MY_QUEUE_NAME = "my_queue_name";
    public static final String MY_EXCHANGE_NAME = "my_exchange_name";
    public static final String MY_ROUTING_KEY = "my_queue_name";

    @Bean
    Queue queue() {
        return new Queue(MY_QUEUE_NAME, true, false, false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(MY_EXCHANGE_NAME, true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(MY_ROUTING_KEY);
    }
}
