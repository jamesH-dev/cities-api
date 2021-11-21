package com.github.jameshdev.citiesapi.services;

import com.github.jameshdev.citiesapi.entities.State;
import com.github.jameshdev.citiesapi.repositories.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {
    private final StateRepository repository;

    public StateService(StateRepository repository) {
        this.repository = repository;
    }

    public Page <State> getAll(Pageable page){
        return repository.findAll(page);
    }

    public Optional <State> getOne(Long id){
        return repository.findById(id);
    }
}
