package br.edu.ifpb.exemplosjpa.repository;

import br.edu.ifpb.exemplosjpa.model.TicketField;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketFieldRepository extends GenericCrudRepository<TicketField, Long> {
}
