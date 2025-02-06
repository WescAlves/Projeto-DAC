package br.edu.ifpb.exemplosjpa.DTO;

import br.edu.ifpb.exemplosjpa.model.TicketField;

public record TicketFieldDTO(String name, String value, Long ticketTypeId) {

    public TicketField toTicketField(){
        return new TicketField(name, value);
    }

}
