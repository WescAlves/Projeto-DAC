package br.edu.ifpb.exemplosjpa.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long quantity;

    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TicketField> fields = new ArrayList<>();

    public TicketType(String name, long quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
