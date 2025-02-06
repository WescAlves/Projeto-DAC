package br.edu.ifpb.exemplosjpa.DTO;

import br.edu.ifpb.exemplosjpa.model.TicketType;

public record TicketTypeDTO(String name, Long quantity, double price, Long eventId) {

    public TicketType toTicketType(){
        return new TicketType(name, quantity, price);
    }
}
