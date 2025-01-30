package br.edu.ifpb.exemplosjpa.repository;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends GenericCrudRepository<Event, Long> {

    Optional<Event> findEventByPlaceAndDates (Place place, List<LocalDateTime> dates);



}
