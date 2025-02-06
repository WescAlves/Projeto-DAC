package br.edu.ifpb.exemplosjpa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public abstract class GenericCrudService <T, ID> {

    protected JpaRepository<T, ID> repository;

    public GenericCrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T create(T obj){
        return repository.save(obj);
    }

    public List<T>getAll(){
        return repository.findAll();
    }

    public Optional<T> findById(ID id){
        return repository.findById(id);
    }

    public void deleteById(ID id){
        repository.deleteById(id);
    }
}
