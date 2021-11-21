package com.github.jameshdev.citiesapi.services;

import com.github.jameshdev.citiesapi.entities.City;
import com.github.jameshdev.citiesapi.repositories.CityRepository;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {
    private final CityRepository cityRepository;

    public DistanceService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(final long city1, final long city2){
        return cityRepository.distanceByPoints(city1, city2);
    }

    public Double distanceByCubeInMeters(long city1, long city2){
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1, city2));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());


    }
}
