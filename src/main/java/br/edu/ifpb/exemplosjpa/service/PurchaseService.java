package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.DTO.PurchasseDTO;
import br.edu.ifpb.exemplosjpa.DTO.TicketsDTO;
import br.edu.ifpb.exemplosjpa.exceptions.EventNotFoundException;
import br.edu.ifpb.exemplosjpa.exceptions.TicketTypeNotFoundException;
import br.edu.ifpb.exemplosjpa.exceptions.UserNotFoundException;
import br.edu.ifpb.exemplosjpa.model.Purchase;
import br.edu.ifpb.exemplosjpa.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService extends GenericCrudService<Purchase, Long>{

    private TicketTypeService ticketTypeService;
    private EventService eventService;
    private UserService userService;

    public PurchaseService(JpaRepository<Purchase, Long> repository, TicketTypeService ticketTypeService, EventService eventService, UserService userService) {
        super(repository);
        this.ticketTypeService = ticketTypeService;
        this.eventService = eventService;
        this.userService = userService;
    }

    public Purchase create(PurchasseDTO dtos){
        Purchase purchase = new Purchase();
        List<Ticket> tickets = new ArrayList<>();
        for (TicketsDTO dto: dtos.ticketDTOs()) {
            Ticket ticket = new Ticket();
            ticket.setDates(dto.dates());
            ticket.setTicketType(ticketTypeService.findById(dto.ticketTypeId()).orElseThrow(TicketTypeNotFoundException::new));
            ticket.setEvent(eventService.findById(dto.idEvent()).orElseThrow(EventNotFoundException::new));
            ticket.setUser(userService.findById(dto.idUser()).orElseThrow(UserNotFoundException::new));
            tickets.add(ticket);
        }
        purchase.setBuyer(userService.findById(dtos.buyerId()).orElseThrow(UserNotFoundException::new));
        purchase.setPurchaseDate(LocalDate.now());
        purchase.setTickets(tickets);
        return repository.save(purchase);
    }
}
