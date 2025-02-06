package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends GenericCrudService<Ticket, Long>{
    public TicketService(JpaRepository<Ticket, Long> repository) {
        super(repository);
    }
}
