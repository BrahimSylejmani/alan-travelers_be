package org.alan.flightbooking.controller;

import org.alan.flightbooking.model.Baggage;
import org.alan.flightbooking.service.BaggageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/baggage")
public class BaggageController {

    private BaggageService baggageService;

    public BaggageController(BaggageService baggageService){
        this.baggageService = baggageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Baggage createBaggage(@RequestBody Baggage baggage){ return baggageService.save(baggage);}


    @GetMapping
    public ResponseEntity<List<Baggage>> findAll(){
        return ResponseEntity.ok(baggageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Baggage> getBaggageById(@PathVariable Long id){
        return ResponseEntity.ok(baggageService.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Baggage> updateBaggage(@PathVariable Long id, @RequestBody Baggage baggage){

        if(id == null || baggage == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(baggageService.update(id, baggage));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBaggageById(@PathVariable Long id){
        baggageService.delete(id);
    }

}
