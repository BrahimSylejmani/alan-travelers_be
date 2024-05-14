package org.alan.flightbooking.controller;


import org.alan.flightbooking.model.Airport;
import org.alan.flightbooking.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/airport")
public class AirportController {

    private AirportService airportService;

    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Airport createAirport(@RequestBody Airport airport){
        return airportService.save(airport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> findById(@PathVariable Long id){
        return ResponseEntity.ok(airportService.findById(id));
    }


}
