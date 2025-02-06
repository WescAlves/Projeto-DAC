package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends GenericCrudService<Purchase, Long>{

    public PurchaseService(JpaRepository<Purchase, Long> repository) {
        super(repository);
    }
}
