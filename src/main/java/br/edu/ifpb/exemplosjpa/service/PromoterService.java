package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Promoter;
import br.edu.ifpb.exemplosjpa.repository.PromoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PromoterService extends GenericCrudService<Promoter, Long>{
    @Autowired
    private PromoterRepository promoterRepository;
    public PromoterService(PromoterRepository promoterRepository) {
        super(promoterRepository);
    }
}
