package br.edu.ifpb.exemplosjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface GenericCrudRepository <T, ID> extends JpaRepository <T, ID>{
}
