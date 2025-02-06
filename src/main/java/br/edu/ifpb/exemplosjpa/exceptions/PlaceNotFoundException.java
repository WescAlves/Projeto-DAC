package br.edu.ifpb.exemplosjpa.exceptions;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException() {
        super("The place does not exist yet, please create the place first.");
    }
}
