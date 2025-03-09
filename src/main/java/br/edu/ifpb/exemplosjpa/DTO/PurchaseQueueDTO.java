package br.edu.ifpb.exemplosjpa.DTO;

import br.edu.ifpb.exemplosjpa.model.Ticket;
import java.util.List;

public record PurchaseQueueDTO(Long idPurchase, List<Ticket> tickets) {
}