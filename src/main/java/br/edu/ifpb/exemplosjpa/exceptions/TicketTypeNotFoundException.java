package br.edu.ifpb.exemplosjpa.exceptions;

public class TicketTypeNotFoundException extends RuntimeException {
    public TicketTypeNotFoundException() {
        super("Sorry, i coudn't find the Ticket Type you're looking for");
    }
}
