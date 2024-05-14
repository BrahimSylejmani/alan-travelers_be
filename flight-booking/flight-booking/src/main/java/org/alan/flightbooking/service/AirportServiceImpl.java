package org.alan.flightbooking.service;


import org.alan.flightbooking.model.Airport;
import org.alan.flightbooking.repository.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService{


    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }


    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findById(Long id) {
        return airportRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport with id " + id + " is not found."));
    }

    @Override
    public Airport update(Long id, Airport airport) {
        airportRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport with id " + id + " is not found."));
        return airportRepository.save(airport);
    }

    @Override
    public void delete(Long id) {
        airportRepository.deleteById(id);
    }

}
