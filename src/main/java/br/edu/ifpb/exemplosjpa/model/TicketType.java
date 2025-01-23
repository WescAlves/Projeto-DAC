package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Ticket ticket;

    private String name;

    private long quantity;

    private double price;
}
