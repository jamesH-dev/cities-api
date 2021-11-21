package com.github.jameshdev.citiesapi.repositories;

import com.github.jameshdev.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
