package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class TicketDistribuition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private TicketType ticketType;

    private Long value;

    public TicketDistribuition(TicketType ticketType, Long value) {
        this.ticketType = ticketType;
        this.value = value;
    }

}
