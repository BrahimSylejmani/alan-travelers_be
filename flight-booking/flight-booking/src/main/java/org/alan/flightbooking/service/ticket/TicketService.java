package org.alan.flightbooking.service.ticket;


import org.alan.flightbooking.common.dto.ticket.TicketRequestDTO;
import org.alan.flightbooking.common.dto.ticket.TicketResponseDTO;
import org.alan.flightbooking.model.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket createTicket(TicketRequestDTO ticketRequestDTO, String userId);
    List<TicketResponseDTO> getAllTickets();

    TicketResponseDTO getTicketById(Long id);

    TicketResponseDTO updateTicket(Long id, TicketRequestDTO ticketRequestDTO);

    void deleteTicket(Long id);
}