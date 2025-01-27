package br.edu.ifpb.exemplosjpa.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
@Entity
@Table

public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;
    @ElementCollection
    private List<LocalDateTime> dates;
    @OneToOne
    private Place place;

    private long maxCapacity;

    @ElementCollection
    @CollectionTable(
            joinColumns = @JoinColumn(name = "event_id")
    )
    @Column(name = "type_value")
    @MapKeyColumn(name = "type_id")
    private HashMap<TicketType, Long> ticketsDistribution;

    private String category;

}
