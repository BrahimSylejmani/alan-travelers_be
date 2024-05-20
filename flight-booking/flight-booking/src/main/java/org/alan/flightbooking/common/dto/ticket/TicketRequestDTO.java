package org.alan.flightbooking.common.dto.ticket;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.text.Format;
import java.time.LocalDate;

@Data
public class TicketRequestDTO {

    @NotBlank(message = "Passenger name cannot be blank")
    private String passengerName;

    @NotBlank(message = "Seat number cannot be blank")
    private String seatNumber;

    @NotBlank(message = "Ticket class cannot be blank")
    private String ticketClass;

    @NotNull(message = "Ticket price cannot be null")
    private BigDecimal ticketPrice;

    @NotBlank(message = "Ticket status cannot be blank")
    private String ticketStatus;

    @NotNull(message = "Booking date and time cannot be null")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate bookingDate;

    @NotBlank(message = "Passenger email cannot be blank")
    private String passengerEmail;

    @NotBlank(message = "Passenger phone number cannot be blank")
    private String passengerPhoneNumber;

    @NotBlank(message = "Payment status cannot be blank")
    private String paymentStatus;
}
