package br.edu.ifpb.exemplosjpa.repository;

import br.edu.ifpb.exemplosjpa.model.TicketType;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends GenericCrudRepository<TicketType, Long> {



}
