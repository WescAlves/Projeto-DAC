package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Place;
import br.edu.ifpb.exemplosjpa.repository.EventRepository;
import br.edu.ifpb.exemplosjpa.repository.PlaceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlaceService extends GenericCrudService<Place, Long>{

    private PlaceRepository placeRepository;
    private EventRepository eventRepository;
    public PlaceService(JpaRepository<Place, Long> repository, PlaceRepository placeRepository, EventRepository eventRepository) {
        super(repository);
        this.placeRepository = placeRepository;
        this.eventRepository = eventRepository;
    }



}
