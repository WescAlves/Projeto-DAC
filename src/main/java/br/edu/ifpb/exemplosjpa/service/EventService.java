package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Place;
import br.edu.ifpb.exemplosjpa.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService extends GenericCrudService<Event, Long>{
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event create (Event event){
        if(verifyConflictDateAndPlace(event.getPlace(), event.getDates())){
            throw new RuntimeException("The place has already have events scheduled at this date");
        }
        return eventRepository.save(event);
    }

    public boolean verifyConflictDateAndPlace(Place place, List<LocalDateTime> dates){
        Optional<Event> event = eventRepository.findEventByPlaceAndDates(place, dates);
        return event.isPresent();
    }


}
