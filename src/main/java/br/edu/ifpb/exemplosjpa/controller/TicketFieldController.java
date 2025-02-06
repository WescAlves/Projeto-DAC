package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.DTO.TicketFieldDTO;
import br.edu.ifpb.exemplosjpa.exceptions.TicketTypeNotFoundException;
import br.edu.ifpb.exemplosjpa.model.TicketField;
import br.edu.ifpb.exemplosjpa.model.TicketType;
import br.edu.ifpb.exemplosjpa.service.TicketFieldService;
import br.edu.ifpb.exemplosjpa.service.TicketTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket_field")
public class TicketFieldController {

    private TicketFieldService ticketFieldService;

    private TicketTypeService ticketTypeService;

    public TicketFieldController(TicketFieldService ticketFieldService, TicketTypeService ticketTypeService) {
        this.ticketFieldService = ticketFieldService;
        this.ticketTypeService = ticketTypeService;
    }

    @PostMapping
    public ResponseEntity<TicketType> create (@RequestBody TicketFieldDTO dto){
        TicketType ticketType = ticketTypeService.findById(dto.ticketTypeId()).orElseThrow(TicketTypeNotFoundException::new);
        ticketType.getFields().add(dto.toTicketField());
        ticketTypeService.create(ticketType);
        return ResponseEntity.ok(ticketType);
    }


    @GetMapping
    public List<TicketField> getAll(){
        return ticketFieldService.getAll();
    }

    @GetMapping("/{id}")
    public TicketField getById(@PathVariable Long id){
        return ticketFieldService.findById(id).orElseThrow();
    }
}
