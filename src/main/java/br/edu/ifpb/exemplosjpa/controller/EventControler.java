package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/event", produces = "application/json")
public class EventControler {

    private EventService eventService;

    public EventControler(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event){
        return ResponseEntity.ok(eventService.create(event));
    }

    @GetMapping
    public List<Event> findAll(){
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id){
        return eventService.findById(id);
    }




}
