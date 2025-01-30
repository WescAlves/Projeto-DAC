package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.TicketType;
import br.edu.ifpb.exemplosjpa.service.TicketTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket_type")
public class TicketTypeController {

    private TicketTypeService ticketTypeService;

    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @PostMapping
    public ResponseEntity<TicketType> create (@RequestBody TicketType ticketType){
        return ResponseEntity.ok(ticketTypeService.create(ticketType));
    }


    @GetMapping
    public List<TicketType> getAll(){
        return ticketTypeService.getAll();
    }

    @GetMapping("/{id}")
    public TicketType getById(@PathVariable Long id){
        return ticketTypeService.findById(id);
    }
}
