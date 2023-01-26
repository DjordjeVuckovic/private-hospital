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
    @Value("${EXCHANGE}")
    public   String EXCHANGE ;
    @Value("${ROUTING_KEY}")
    public   String ROUTING_KEY;
    public static String QUEUE_STATIC;
    public static String EXCHANGE_STATIC;
    public static String ROUTING_KEY_STATIC;

    @PostConstruct
    public void init(){
        QUEUE_STATIC = QUEUE;
        EXCHANGE_STATIC = EXCHANGE;
        ROUTING_KEY_STATIC = ROUTING_KEY;
    }

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_STATIC);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_STATIC);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_STATIC);
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
