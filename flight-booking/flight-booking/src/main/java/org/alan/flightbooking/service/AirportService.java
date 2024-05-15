package org.alan.flightbooking.service;

import org.alan.flightbooking.model.Airport;

import java.util.List;

public interface AirportService {

    Airport save(Airport airport);

    List<Airport> findAll();

    Airport findById(Long id);

    Airport update(Long id, Airport airport);

    void delete(Long id);
}
