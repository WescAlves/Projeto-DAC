package br.edu.ifpb.exemplosjpa.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException() {
        super("Sorry, i couldn't find the event you're looking for!");
    }
    public EventNotFoundException(String message){
        super(message);
    }
}
