package br.edu.ifpb.exemplosjpa.config;

import br.edu.ifpb.exemplosjpa.amqp.QueuesAmqp;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration
public class QueuesConfig {



        @Bean
        public Queue emailQueue() {
            return new Queue(QueuesAmqp.EMAIL_QUEUE.getValue());
        }
        @Bean
        public Queue purchaseQueue() {
            return new Queue(QueuesAmqp.PURCHASE_QUEUE.getValue());
        }

        @Bean
        public TopicExchange exchange() {
            return new TopicExchange(QueuesAmqp.EXCHANGE.getValue());
        }
        @Bean
        public Binding emailBinding(Queue emailQueue, TopicExchange exchange) {
            return BindingBuilder.bind(emailQueue).to(exchange).with(QueuesAmqp.EMAIL_QUEUE_ROUTING_KEY.getValue());
        }
        @Bean
        public Binding purchaseBinding(Queue purchaseQueue, TopicExchange exchange) {
            return BindingBuilder.bind(purchaseQueue).to(exchange).with(QueuesAmqp.PURCHASE_QUEUE_ROUTING_KEY.getValue());
        }
    }

