package com.github.jameshdev.citiesapi.controllers;

import com.github.jameshdev.citiesapi.entities.State;
import com.github.jameshdev.citiesapi.services.StateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/states")
public class StateResourse {

    private final StateService service;

    public StateResourse(StateService service) {
        this.service = service;
    }

    @GetMapping
    public Page <State> states(Pageable page){
        return service.getAll(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity getOne (@PathVariable  Long id) {
        Optional <State> optional = service.getOne(id);

        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
