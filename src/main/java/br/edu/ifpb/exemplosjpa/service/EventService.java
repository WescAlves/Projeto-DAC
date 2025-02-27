package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.DTO.EventDto;
import br.edu.ifpb.exemplosjpa.exceptions.PlaceNotAvailableException;
import br.edu.ifpb.exemplosjpa.exceptions.PlaceNotFoundException;
import br.edu.ifpb.exemplosjpa.exceptions.PlacesCapacityNotEnoughException;
import br.edu.ifpb.exemplosjpa.exceptions.PromoterNotFoundException;
import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Place;
import br.edu.ifpb.exemplosjpa.model.Promoter;
import br.edu.ifpb.exemplosjpa.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService extends GenericCrudService<Event, Long> {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private PromoterService promoterService;

    public EventService(EventRepository eventRepository) {
        super(eventRepository);
    }

    public Event create(EventDto dto) {
        Event event = dto.toEvent();
        Place place = placeService.findById(dto.placeId()).orElseThrow(PlaceNotFoundException::new);
        Promoter promoter = promoterService.findById(dto.promoterId()).orElseThrow(PromoterNotFoundException::new);
        event.setPlace(place);
        event.setPromoter(promoter);
        if (event.getPlace().getMaxCapacity() <= event.getMaxCapacity()) {
            throw new PlacesCapacityNotEnoughException();
        }
        if (verifyAvailabilityDateAndPlace(event.getPlace(), event.getDates())) {
            return eventRepository.save(event);
        }
        throw new PlaceNotAvailableException();
    }

    public boolean verifyAvailabilityDateAndPlace(Place place, List<LocalDateTime> dates) {
        List<Event> events = eventRepository.findEventsByPlace(place);
        return isDateAvailable(events, dates);
    }

    public boolean isDateAvailable(List<Event> events, List<LocalDateTime> dates) {

        for (Event event : events) {
            for (LocalDateTime date : dates) {
                if (event.getDates().contains(date)) {
                    return false;
                }
            }
        }
        return true;
    }

}
