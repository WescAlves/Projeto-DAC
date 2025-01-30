package br.edu.ifpb.exemplosjpa.repository;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericCrudRepository<User, Long> {
}
