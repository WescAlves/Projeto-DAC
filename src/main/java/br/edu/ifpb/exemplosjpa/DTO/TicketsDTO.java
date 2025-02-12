package br.edu.ifpb.exemplosjpa.DTO;

import br.edu.ifpb.exemplosjpa.model.Ticket;

import java.time.LocalDate;
import java.util.List;

public record TicketsDTO(Long ticketTypeId,
                         List<LocalDate> dates,
                         Long idEvent,
                         Long idUser) {

}
