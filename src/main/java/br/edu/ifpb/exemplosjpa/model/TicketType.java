package br.edu.ifpb.exemplosjpa.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@Entity
@Table
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    @JsonIgnore
    @OneToMany(mappedBy = "ticketType")
    private List<Ticket> tickets;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TicketField> fields = new ArrayList<>();

    public TicketType(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
