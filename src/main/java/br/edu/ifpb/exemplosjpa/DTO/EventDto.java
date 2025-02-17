package br.edu.ifpb.exemplosjpa.DTO;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Place;
import br.edu.ifpb.exemplosjpa.model.TicketType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public record EventDto(
        String name,
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        List<LocalDateTime> dates,
        Long placeId,


        long maxCapacity,
        String category
) {

    public Event toEvent() {
        Event event = new Event(name, description, dates, maxCapacity, category);
        return event;
    }

}
