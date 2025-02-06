package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.TicketField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketFieldService extends GenericCrudService<TicketField, Long>{
    public TicketFieldService(JpaRepository<TicketField, Long> repository) {
        super(repository);
    }
}
