package com.teachhealth.hospitalbe.common;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MessagingConfig {
    @Value("${QUEUE}")
    public  String QUEUE;
    @Value("${QUEUE_HOSPITAL_1}")
    public  String QUEUE1;
    @Value("${EXCHANGE}")
    public   String EXCHANGE ;
    @Value("${ROUTING_KEY}")
    public   String ROUTING_KEY;
    @Value("${ROUTING_KEY_HOSPITAL_1}")
    public   String ROUTING_KEY1;
    public static String QUEUE_STATIC;
    public static String QUEUE_STATIC1;
    public static String EXCHANGE_STATIC;
    public static String ROUTING_KEY_STATIC;
    public static String ROUTING_KEY_STATIC1;

    @PostConstruct
    public void init(){
        QUEUE_STATIC = QUEUE;
        QUEUE_STATIC1 = QUEUE1;
        EXCHANGE_STATIC = EXCHANGE;
        ROUTING_KEY_STATIC = ROUTING_KEY;
        ROUTING_KEY_STATIC1 = ROUTING_KEY1;
    }

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_STATIC);
    }
    @Bean
    public Queue queue1(){
        return new Queue(QUEUE_STATIC);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_STATIC);
    }
    @Bean
    public Binding binding(TopicExchange exchange){
        return BindingBuilder.bind(queue()).to(exchange).with(ROUTING_KEY_STATIC);
    }
    @Bean
    public Binding binding1(TopicExchange exchange){
        return BindingBuilder.bind(queue1()).to(exchange).with(ROUTING_KEY_STATIC);
    }
    @Bean
    public MessageConverter converter(){
        return  new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
