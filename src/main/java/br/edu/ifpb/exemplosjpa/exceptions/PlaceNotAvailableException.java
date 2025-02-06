package br.edu.ifpb.exemplosjpa.exceptions;

public class PlaceNotAvailableException extends RuntimeException{
    public PlaceNotAvailableException() {
        super("The place has already have events scheduled at this date");
    }
}
