package org.alan.flightbooking.service;

import org.alan.flightbooking.model.Baggage;

import java.util.List;

public interface BaggageService {

    Baggage save(Baggage baggage);

    List<Baggage> findAll();

    Baggage findById(Long id);

    Baggage update(Long id, Baggage baggage);

    void delete(Long id);

}
