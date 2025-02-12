package br.edu.ifpb.exemplosjpa.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found, please, verify the buyer!!");
    }
}
