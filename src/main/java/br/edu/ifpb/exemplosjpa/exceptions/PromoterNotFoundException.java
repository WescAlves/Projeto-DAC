package br.edu.ifpb.exemplosjpa.exceptions;

public class PromoterNotFoundException extends RuntimeException {
    public PromoterNotFoundException() {
        super("Sorry, i couldn't find the promoter!");
    }

    public PromoterNotFoundException(String message) {
        super(message);
    }
}
