package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.DTO.TicketTypeDTO;
import br.edu.ifpb.exemplosjpa.exceptions.EventNotFoundException;
import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.TicketDistribuition;
import br.edu.ifpb.exemplosjpa.model.TicketType;
import br.edu.ifpb.exemplosjpa.service.EventService;
import br.edu.ifpb.exemplosjpa.service.TicketTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket_type")
public class TicketTypeController {

    private TicketTypeService ticketTypeService;
    private EventService eventService;

    public TicketTypeController(TicketTypeService ticketTypeService, EventService eventService) {
        this.ticketTypeService = ticketTypeService;
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<List<TicketType>> create(@RequestBody TicketTypeDTO dto) {
        Event event = eventService.findById(dto.eventId()).orElseThrow(EventNotFoundException::new);
        TicketType ticketType = dto.toTicketType();
        event.getTicketTypes().add(ticketType);
        TicketDistribuition ticketDistribuition = new TicketDistribuition(ticketType, dto.quantity());
        event.getTicketDistribuitions().add(ticketDistribuition);
        eventService.create(event);
        return ResponseEntity.ok(event.getTicketTypes());
    }

    @GetMapping
    public List<TicketType> getAll() {
        return ticketTypeService.getAll();
    }

    @GetMapping("/{id}")
    public List<TicketType> getByEventId(@PathVariable Long id) {
        Event event = eventService.findById(id).orElseThrow(EventNotFoundException::new);
        return event.getTicketTypes();
    }
}
