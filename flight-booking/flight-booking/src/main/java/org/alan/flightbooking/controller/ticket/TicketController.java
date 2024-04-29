package org.alan.flightbooking.controller.ticket;
import org.alan.flightbooking.common.dto.ticket.TicketRequestDTO;
import org.alan.flightbooking.common.dto.ticket.TicketResponseDTO;
import org.alan.flightbooking.service.ticket.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponseDTO createTicket(@RequestBody TicketRequestDTO ticketRequestDTO) {
        return ticketService.createTicket(ticketRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> getAllTickets() {
        List<TicketResponseDTO> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable Long id) {
        TicketResponseDTO ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> updateTicket(@PathVariable Long id, @Valid @RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO updatedTicket = ticketService.updateTicket(id, ticketRequestDTO);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
