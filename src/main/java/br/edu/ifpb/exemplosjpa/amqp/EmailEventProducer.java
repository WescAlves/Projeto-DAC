package br.edu.ifpb.exemplosjpa.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exemplosjpa.email.Email;

@Service
public class EmailEventProducer {
    public final AmqpTemplate amqpTemplate;

    public EmailEventProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendEventEmail(Email email) {
        amqpTemplate.convertAndSend(QueuesAmqp.EXCHANGE.getValue(), QueuesAmqp.EMAIL_QUEUE_ROUTING_KEY.getValue(),
                email);
    }
}