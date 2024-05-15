package org.alan.flightbooking.repository;

import org.alan.flightbooking.model.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Long> {
}
