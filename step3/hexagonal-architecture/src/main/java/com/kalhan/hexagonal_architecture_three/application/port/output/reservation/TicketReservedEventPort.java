package com.kalhan.hexagonal_architecture_three.application.port.output.reservation;

import com.kalhan.hexagonal_architecture_three.domain.common.event.EventPublisher;
import com.kalhan.hexagonal_architecture_three.domain.ticket.event.TicketReservedEvent;

public interface TicketReservedEventPort extends EventPublisher<TicketReservedEvent> {

    void publish(TicketReservedEvent ticketReservedEvent);
}
