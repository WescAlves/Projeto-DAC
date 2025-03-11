package br.edu.ifpb.exemplosjpa.email;

import java.io.Serializable;

public record Email(String to, String subject, String body) implements Serializable {

}
