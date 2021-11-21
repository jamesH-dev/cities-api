package com.github.jameshdev.citiesapi.controllers;

import com.github.jameshdev.citiesapi.entities.Country;
import com.github.jameshdev.citiesapi.services.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResourse {

    public final CountryService service;

    public CountryResourse(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Country> countries(Pageable Page) {
        return service.getAll(Page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = service.getOne(id);

        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
