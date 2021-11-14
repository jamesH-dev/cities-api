package com.github.jameshdev.citiesapi.states.repository;

import com.github.jameshdev.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
