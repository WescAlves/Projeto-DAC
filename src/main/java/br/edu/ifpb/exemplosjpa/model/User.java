package br.edu.ifpb.exemplosjpa.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "buyer")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String cpf;

}
