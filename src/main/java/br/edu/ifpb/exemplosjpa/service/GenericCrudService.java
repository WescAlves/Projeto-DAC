package br.edu.ifpb.exemplosjpa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenericCrudService <T, ID> {

    private JpaRepository<T, ID> repository;

    public GenericCrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public GenericCrudService() {
    }

    public T create(T obj){
        return repository.save(obj);
    }

    public List<T>getAll(){
        return repository.findAll();
    }

    public T findById(ID id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
    }

    public void deleteById(ID id){
        repository.deleteById(id);
    }
}
