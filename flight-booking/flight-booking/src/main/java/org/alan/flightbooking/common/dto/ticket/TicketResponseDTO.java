package org.alan.flightbooking.common.dto.ticket;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TicketResponseDTO {
    private Long id;
    private String passengerName;
    private String seatNumber;
    private String ticketClass;
    private BigDecimal ticketPrice;
    private String ticketStatus;
    private LocalDateTime bookingDate;
    private String passengerEmail;
    private String passengerPhoneNumber;
    private String paymentStatus;
}