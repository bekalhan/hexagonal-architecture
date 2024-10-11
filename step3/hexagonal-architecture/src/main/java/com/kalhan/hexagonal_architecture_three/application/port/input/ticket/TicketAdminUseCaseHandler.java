package com.kalhan.hexagonal_architecture_three.application.port.input.ticket;

import com.kalhan.hexagonal_architecture_three.domain.common.DomainComponent;
import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.VoidEmptyUseCaseHandler;
import com.kalhan.hexagonal_architecture_three.application.port.output.ticket.TicketOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class TicketAdminUseCaseHandler implements VoidEmptyUseCaseHandler {
    private final TicketOutputPort ticketOutputPort;

    public void handle() {
        ticketOutputPort.deleteAll();
    }
}
