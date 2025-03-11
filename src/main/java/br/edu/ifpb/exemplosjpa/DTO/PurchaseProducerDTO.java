package br.edu.ifpb.exemplosjpa.DTO;

import java.io.Serializable;
import java.util.List;

public record PurchaseProducerDTO(List<TicketProducerDTO> ticketsDTO) implements Serializable {
}
