package br.edu.ifpb.exemplosjpa.repository;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Promoter;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoterRepository extends GenericCrudRepository<Promoter, Long> {
}
