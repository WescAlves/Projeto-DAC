package br.edu.ifpb.exemplosjpa.service;

import br.edu.ifpb.exemplosjpa.model.Event;
import br.edu.ifpb.exemplosjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericCrudService<User, Long>{
    public UserService(JpaRepository<User, Long> repository) {
        super(repository);
    }
}
