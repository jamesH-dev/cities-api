package com.github.jameshdev.citiesapi.repositories;

import com.github.jameshdev.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
