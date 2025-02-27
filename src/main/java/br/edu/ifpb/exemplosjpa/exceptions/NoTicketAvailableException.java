package br.edu.ifpb.exemplosjpa.exceptions;

public class NoTicketAvailableException extends RuntimeException {
    public NoTicketAvailableException() {
        super("Sorry, there's no tickets available for your modality!");
    }

    public NoTicketAvailableException(String message) {
        super(message);
    }
}
