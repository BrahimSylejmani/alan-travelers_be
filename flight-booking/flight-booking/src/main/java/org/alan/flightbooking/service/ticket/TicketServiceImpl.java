package org.alan.flightbooking.service.ticket;


import org.alan.flightbooking.common.dto.ticket.TicketRequestDTO;
import org.alan.flightbooking.common.dto.ticket.TicketResponseDTO;
import org.alan.flightbooking.common.mapper.TicketMapper;
import org.alan.flightbooking.model.Ticket;
import org.alan.flightbooking.model.User;
import org.alan.flightbooking.repository.TicketRepository;
import org.alan.flightbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TicketResponseDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticketMapper::mapTicketToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketResponseDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with id: " + id));
        return ticketMapper.mapTicketToDTO(ticket);
    }

    @Override
    public TicketResponseDTO createTicket(Long userId, TicketRequestDTO ticketRequestDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Ticket ticket = ticketMapper.mapDTOToTicket(ticketRequestDTO);
        ticket.setUser(user);

        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.mapTicketToDTO(savedTicket);
    }
    @Override
    public TicketResponseDTO updateTicket(Long id, TicketRequestDTO ticketRequestDTO) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with id: " + id));
        ticketMapper.updateTicketFromDTO(ticketRequestDTO, existingTicket);
        Ticket updatedTicket = ticketRepository.save(existingTicket);
        return ticketMapper.mapTicketToDTO(updatedTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
