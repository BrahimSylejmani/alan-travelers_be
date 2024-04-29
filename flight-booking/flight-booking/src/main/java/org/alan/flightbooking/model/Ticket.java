package org.alan.flightbooking.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String passengerName;
    private String seatNumber;
    private String ticketClass;
    private BigDecimal ticketPrice;
    private String ticketStatus;
    private LocalDate bookingDate;
    private String passengerEmail;
    private String passengerPhoneNumber;
    private String paymentStatus;
}
