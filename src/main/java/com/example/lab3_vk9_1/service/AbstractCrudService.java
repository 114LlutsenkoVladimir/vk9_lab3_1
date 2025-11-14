package com.example.lab3_vk9_1.service;

import com.example.lab3_vk9_1.repository.GenericRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

public class AbstractCrudService<T, ID, RP extends GenericRepository<T, ID>> {

    @Inject
    protected RP repository;

    public void create(T entity) {
        repository.create(entity);
    }

    public T findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional
    public T update(T entity) {
        return repository.update(entity);
    }

    public void delete(ID id) {
        repository.delete(id);
    }

}
