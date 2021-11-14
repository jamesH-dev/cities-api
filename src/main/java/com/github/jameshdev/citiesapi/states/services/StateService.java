package com.github.jameshdev.citiesapi.states.services;

import com.github.jameshdev.citiesapi.states.State;
import com.github.jameshdev.citiesapi.states.repository.StateRepository;
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
