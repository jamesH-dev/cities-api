package com.github.jameshdev.citiesapi.countries.repository;

import com.github.jameshdev.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
