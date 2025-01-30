package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.Ticket;
import br.edu.ifpb.exemplosjpa.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> create (@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketService.create(ticket));
    }


    @GetMapping
    public List<Ticket> getAll(){
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id){
        return ticketService.findById(id);
    }
}
