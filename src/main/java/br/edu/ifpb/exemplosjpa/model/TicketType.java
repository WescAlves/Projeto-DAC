package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long quantity;

    private double price;

    @OneToMany
    private List<TicketField> fields;
}
