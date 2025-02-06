package br.edu.ifpb.exemplosjpa.exceptions;

public class PlacesCapacityNotEnoughException extends RuntimeException {
    public PlacesCapacityNotEnoughException() {
        super("The place hasn't the capacity to host this event.");
    }
}
