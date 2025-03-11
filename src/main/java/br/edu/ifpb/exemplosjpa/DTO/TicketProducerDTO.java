package br.edu.ifpb.exemplosjpa.DTO;

import java.io.Serializable;

public record TicketProducerDTO(Long id, String cpf) implements Serializable {
}
