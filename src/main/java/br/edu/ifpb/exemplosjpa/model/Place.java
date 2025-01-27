package br.edu.ifpb.exemplosjpa.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table

public class Place {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String country;

    private String city;

    private String street;
    @Nullable
    private String description;

    @Nullable
    private String number;

    private Long maxCapacity;
}
