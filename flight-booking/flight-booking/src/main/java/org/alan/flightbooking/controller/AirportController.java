package org.alan.flightbooking.controller;


import org.alan.flightbooking.model.Airport;
import org.alan.flightbooking.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports(){
        return ResponseEntity.ok(airportService.findAll());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airport){

        if(id == null || airport == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airportService.update(id, airport));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAirportById(@PathVariable Long id){
        airportService.delete(id);
    }


}
