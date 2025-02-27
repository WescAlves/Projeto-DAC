package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.DTO.PurchaseDTO;

import br.edu.ifpb.exemplosjpa.DTO.TicketsDTO;
import br.edu.ifpb.exemplosjpa.email.Email;
import br.edu.ifpb.exemplosjpa.email.EmailService;
import br.edu.ifpb.exemplosjpa.exceptions.EventNotFoundException;
import br.edu.ifpb.exemplosjpa.exceptions.NoTicketAvailableException;
import br.edu.ifpb.exemplosjpa.exceptions.TicketTypeNotFoundException;
import br.edu.ifpb.exemplosjpa.exceptions.UserNotFoundException;
import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Purchase;
import br.edu.ifpb.exemplosjpa.model.Ticket;
import br.edu.ifpb.exemplosjpa.model.TicketDistribuition;
import br.edu.ifpb.exemplosjpa.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService extends GenericCrudService<Purchase, Long> {

    private TicketTypeService ticketTypeService;
    private EventService eventService;
    private UserService userService;
    private EmailService emailService;

    public PurchaseService(JpaRepository<Purchase, Long> repository, TicketTypeService ticketTypeService,
            EventService eventService, UserService userService, EmailService emailService) {
        super(repository);
        this.ticketTypeService = ticketTypeService;
        this.eventService = eventService;
        this.userService = userService;
        this.emailService = emailService;
    }

    public Purchase create(PurchaseDTO dtos) {
        Purchase purchase = new Purchase();
        List<Ticket> tickets = new ArrayList<>();
        Event event = new Event();
        for (TicketsDTO dto : dtos.ticketDTOs()) {

            event = eventService.findById(dto.idEvent()).orElseThrow(EventNotFoundException::new);
            List<TicketDistribuition> ticketDistribuitions = event.getTicketDistribuitions();

            List<Ticket> ticketsSold = findByEventAndType(dto.idEvent(), dto.ticketTypeId());

            for (TicketDistribuition ticketDistribuition : ticketDistribuitions) {
                if (!(ticketDistribuition.getTicketType().getId() == dto.ticketTypeId()
                        && ticketDistribuition.getValue() > ticketsSold.size())) {
                    throw new NoTicketAvailableException();
                }

                Ticket ticket = new Ticket();
                ticket.setDates(dto.dates());
                ticket.setTicketType(
                        ticketTypeService.findById(dto.ticketTypeId()).orElseThrow(TicketTypeNotFoundException::new));
                ticket.setEvent(eventService.findById(dto.idEvent()).orElseThrow(EventNotFoundException::new));
                ticket.setUser(userService.findById(dto.idUser()).orElseThrow(UserNotFoundException::new));
                tickets.add(ticket);
            }
        }

        User buyer = userService.findById(dtos.buyerId()).orElseThrow(UserNotFoundException::new);
        purchase.setBuyer(buyer);
        purchase.setPurchaseDate(LocalDate.now());
        purchase.setTickets(tickets);
        String eventName = event.getName();
        Email email = new Email(buyer.getEmail(), "Confirmação de compra",
                "Ingresso para o evento: " + eventName + " confirmado!");
        emailService.sendEmail(email);

        return repository.save(purchase);
    }

    public List<Ticket> findByEventAndType(Long idEvent, Long idTicketType) {
        List<Ticket> tickets = new ArrayList<>();
        List<Purchase> allPurchases = repository.findAll();
        for (Purchase purchase : allPurchases) {
            for (Ticket ticket : purchase.getTickets()) {
                if (ticket.getTicketType().getId() == idTicketType &&
                        ticket.getEvent().getId() == idEvent) {
                    tickets.add(ticket);

                }
            }
        }

        return tickets;
    }
}
