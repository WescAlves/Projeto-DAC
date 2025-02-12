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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private TicketType ticketType;

    @ElementCollection
    private List<LocalDate> dates;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
