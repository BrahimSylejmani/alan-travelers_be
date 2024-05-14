package org.alan.flightbooking.service;

import org.alan.flightbooking.model.Baggage;
import org.alan.flightbooking.repository.BaggageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BaggageServiceImpl implements BaggageService{

    private BaggageRepository baggageRepository;

    public BaggageServiceImpl(BaggageRepository baggageRepository){
        this.baggageRepository = baggageRepository;
    }

    @Override
    public Baggage save(Baggage baggage) {
        return baggageRepository.save(baggage);
    }

    @Override
    public List<Baggage> findAll() {
        return baggageRepository.findAll();
    }

    @Override
    public Baggage findById(Long id) {
        return baggageRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Baggage with id "+id+ " not found"));
    }

    @Override
    public Baggage update(Long id, Baggage baggage) {
        baggageRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Baggage with id "+id+ " not found"));

        return baggageRepository.save(baggage);
    }

    @Override
    public void delete(Long id) {
        baggageRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Baggage with id "+id+ " not found"));

         baggageRepository.deleteById(id);

    }
}
