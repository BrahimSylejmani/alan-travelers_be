package org.alan.flightbooking.service.ticket;


import org.alan.flightbooking.common.dto.ticket.TicketRequestDTO;
import org.alan.flightbooking.common.dto.ticket.TicketResponseDTO;

import java.util.List;

public interface TicketService {

    TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO);

    List<TicketResponseDTO> getAllTickets();

    TicketResponseDTO getTicketById(Long id);

    TicketResponseDTO updateTicket(Long id, TicketRequestDTO ticketRequestDTO);

    void deleteTicket(Long id);
}