package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table
@Entity
public class TicketField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String value;

    public TicketField(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
