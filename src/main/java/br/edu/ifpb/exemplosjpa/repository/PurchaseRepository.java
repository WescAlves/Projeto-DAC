package br.edu.ifpb.exemplosjpa.repository;

import br.edu.ifpb.exemplosjpa.model.Purchase;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends GenericCrudRepository<Purchase, Long> {
}
