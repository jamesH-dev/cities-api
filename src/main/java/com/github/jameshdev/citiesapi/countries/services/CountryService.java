package com.github.jameshdev.citiesapi.countries.services;

import com.github.jameshdev.citiesapi.countries.Country;
import com.github.jameshdev.citiesapi.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Page <Country> getAll(Pageable page){
        return repository.findAll(page);
    }

    public Optional <Country> getOne(Long id){
        return repository.findById(id);
    }
}
