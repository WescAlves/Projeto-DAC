package br.edu.ifpb.exemplosjpa.DTO;

import br.edu.ifpb.exemplosjpa.model.Ticket;

import java.util.List;

public record PurchasseDTO(Long buyerId,
                           List<TicketsDTO> ticketDTOs) {
}
