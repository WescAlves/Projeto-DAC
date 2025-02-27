package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketType_id", nullable = false)
    private TicketType ticketType;

    @ElementCollection
    private List<LocalDate> dates;

    @ManyToOne(cascade = CascadeType.ALL)
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
