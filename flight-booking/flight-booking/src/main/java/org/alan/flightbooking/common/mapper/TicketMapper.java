package org.alan.flightbooking.common.mapper;

import org.alan.flightbooking.common.dto.ticket.TicketRequestDTO;
import org.alan.flightbooking.common.dto.ticket.TicketResponseDTO;
import org.alan.flightbooking.model.Ticket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TicketResponseDTO mapTicketToDTO(Ticket ticket) {
        return modelMapper.map(ticket, TicketResponseDTO.class);
    }

    public Ticket mapDTOToTicket(TicketRequestDTO ticketRequestDTO) {
        return modelMapper.map(ticketRequestDTO, Ticket.class);
    }

    public void updateTicketFromDTO(TicketRequestDTO updateDTO, Ticket existingTicket) {
        modelMapper.map(updateDTO, existingTicket);
    }
}
