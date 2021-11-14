package com.github.jameshdev.citiesapi.cities;

import com.github.jameshdev.citiesapi.cities.services.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
