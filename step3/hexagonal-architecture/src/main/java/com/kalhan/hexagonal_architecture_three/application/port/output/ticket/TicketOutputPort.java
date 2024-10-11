package com.kalhan.hexagonal_architecture_three.application.port.output.ticket;

import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import com.kalhan.hexagonal_architecture_three.domain.ticket.usecase.CreateTicket;
import com.kalhan.hexagonal_architecture_three.domain.ticket.usecase.TicketRetrieve;

import java.util.List;

public interface TicketOutputPort {
    Ticket create(CreateTicket createTicket);

    List<Ticket> retrieve(TicketRetrieve ticketRetrieve);

    void deleteAll();
}
