package br.edu.ifpb.exemplosjpa.amqp;

import br.edu.ifpb.exemplosjpa.DTO.PurchaseProducerDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exemplosjpa.DTO.PurchaseQueueDTO;

@Service
public class PurchaseEventProducer {

    public final AmqpTemplate amqpTemplate;



    public PurchaseEventProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendEventPurchase(PurchaseProducerDTO purchase) {
        System.out.println(purchase.ticketsDTO());
        amqpTemplate.convertAndSend(QueuesAmqp.EXCHANGE.getValue(), QueuesAmqp.PURCHASE_QUEUE_ROUTING_KEY.getValue(),
                purchase);
    }
}
