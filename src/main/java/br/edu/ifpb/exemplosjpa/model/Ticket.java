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

    @OneToOne
    private TicketType ticketType;

    @ElementCollection
    private List<LocalDate> dates;

    @OneToOne
    private Event event;

    @OneToOne
    private User user;

}
