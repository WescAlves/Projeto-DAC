package br.edu.ifpb.exemplosjpa.exceptions;

import br.edu.ifpb.exemplosjpa.DTO.ExceptionDTO;
import br.edu.ifpb.exemplosjpa.model.Place;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionConverter {

    @ExceptionHandler(PlaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDTO converter(PlaceNotFoundException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(PlaceNotAvailableException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ExceptionDTO converter(PlaceNotAvailableException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(PlacesCapacityNotEnoughException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ExceptionDTO converter(PlacesCapacityNotEnoughException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDTO converter(EventNotFoundException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(TicketTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDTO converter(TicketTypeNotFoundException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDTO converter(UserNotFoundException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(NoTicketAvailableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ExceptionDTO converter(NoTicketAvailableException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(PromoterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDTO converter(PromoterNotFoundException e) {
        return new ExceptionDTO(e.getMessage());
    }
}
