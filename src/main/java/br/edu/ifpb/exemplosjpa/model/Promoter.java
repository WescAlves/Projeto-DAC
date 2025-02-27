package br.edu.ifpb.exemplosjpa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Promoter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String cpf;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events;
}
