package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class TicketField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private TicketType ticketType;

    private String name;

    private String value;
}
