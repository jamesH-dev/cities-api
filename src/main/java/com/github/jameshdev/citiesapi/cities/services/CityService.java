package com.github.jameshdev.citiesapi.cities.services;

import com.github.jameshdev.citiesapi.cities.City;
import com.github.jameshdev.citiesapi.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page <City> getAll(Pageable page){ return cityRepository.findAll(page); }

    public Optional<City> getOne(Long id){ return cityRepository.findById(id); }

    public Optional<Page<City>> findByUfId(Integer uf, Pageable page) {
        return cityRepository.findByUfId(uf, page);
    }
}
