package com.github.jameshdev.citiesapi.controllers;

import com.github.jameshdev.citiesapi.services.DistanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResourse {
    private final DistanceService service;

    public DistanceResourse(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints (@RequestParam(name = "from") final Long city1,
                                    @RequestParam(name = "to") final Long city2){
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                            @RequestParam(name = "to") final Long city2){
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
    }
}
