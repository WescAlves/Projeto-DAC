package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.DTO.EventDto;
import br.edu.ifpb.exemplosjpa.exceptions.EventNotFoundException;
import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.service.EventService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventControler {

    private Logger logger = LoggerFactory.getLogger(EventControler.class);

    private EventService eventService;

    public EventControler(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventDto dto){
        Event event = this.eventService.create(dto);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public List<Event> findAll(){
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id){
        return eventService.findById(id).orElseThrow(EventNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if(eventService.findById(id).isPresent()){
            eventService.deleteById(id);
            return ResponseEntity.ok("{ message: Event deleted! } ");
        }
        else{throw new EventNotFoundException("Sorry, i couldn't found the event you're trying to delete!");}
    }



}
