package com.github.jameshdev.citiesapi.controllers;

import com.github.jameshdev.citiesapi.entities.City;
import com.github.jameshdev.citiesapi.services.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResourse {

    private final CityService service;

    public CityResourse(CityService service) { this.service = service; }

    @GetMapping
    public Page cities(Pageable page){
        return service.getAll(page);
    }

    @GetMapping ("/{id}")
    public ResponseEntity getOne (@PathVariable  Long id) {
        Optional<City> optional = service.getOne(id);

        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping ("/by-state")
    public ResponseEntity <Page<City>> getByState (@RequestParam(defaultValue = "") Integer uf, Pageable page){
        Optional <Page<City>> optional = service.findByUfId(uf, page);

        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
