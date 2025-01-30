package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.TicketField;
import br.edu.ifpb.exemplosjpa.service.TicketFieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket_field")
public class TicketFieldController {

    private TicketFieldService ticketFieldService;

    public TicketFieldController(TicketFieldService ticketFieldService) {
        this.ticketFieldService = ticketFieldService;
    }

    @PostMapping
    public ResponseEntity<TicketField> create (@RequestBody TicketField ticketField){
        return ResponseEntity.ok(ticketFieldService.create(ticketField));
    }


    @GetMapping
    public List<TicketField> getAll(){
        return ticketFieldService.getAll();
    }

    @GetMapping("/{id}")
    public TicketField getById(@PathVariable Long id){
        return ticketFieldService.findById(id);
    }
}
