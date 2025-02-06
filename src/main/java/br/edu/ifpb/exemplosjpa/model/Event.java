package br.edu.ifpb.exemplosjpa.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.management.ConstructorParameters;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor

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
    @ManyToOne
    private Place place;

    private long maxCapacity;
    @OneToMany(cascade = CascadeType.ALL)

    private List<TicketType> ticketTypes;

    private String category;

    public Event(String name, String description, List<LocalDateTime> dates, long maxCapacity, String category) {
        this.name = name;
        this.description = description;
        this.dates = dates;
        this.ticketTypes = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.category = category;
    }
}
