package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketTypeService extends GenericCrudService<TicketType, Long>{
    public TicketTypeService(JpaRepository<TicketType, Long> repository) {
        super(repository);
    }
}
