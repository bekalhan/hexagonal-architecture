package com.kalhan.hexagonal_architecture_three.application.service;

import com.kalhan.hexagonal_architecture_three.application.port.output.ticket.TicketOutputPort;
import com.kalhan.hexagonal_architecture_three.domain.common.model.Status;
import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import com.kalhan.hexagonal_architecture_three.domain.ticket.usecase.CreateTicket;
import com.kalhan.hexagonal_architecture_three.domain.ticket.usecase.TicketRetrieve;
import com.kalhan.hexagonal_architecture_three.infrastructure.common.customizedexception.exception.TicketApiDataNotFoundException;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.jpa.entity.TicketEntity;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.jpa.repository.MeetupJpaRepository;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.jpa.repository.TicketJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService implements TicketOutputPort {
    private final TicketJpaRepository ticketJpaRepository;
    private final MeetupJpaRepository meetupJpaRepository;

    @Override
    public Ticket create(CreateTicket createTicket) {
        var ticketEntity = new TicketEntity();
        ticketEntity.setStatus(Status.ACTIVE);
        ticketEntity.setReserveDate(LocalDateTime.now());
        ticketEntity.setAccountId(createTicket.getAccountId());
        ticketEntity.setMeetupId(createTicket.getMeetupId());
//        ticketEntity.setPrice(calculateTotalPrice(createTicket));
        ticketEntity.setCount(createTicket.getCount());

        return ticketJpaRepository.save(ticketEntity).toModel();
    }

    @Override
    public List<Ticket> retrieve(TicketRetrieve ticketRetrieve) {
        return ticketJpaRepository.findAllByAccountId(ticketRetrieve.getAccountId()).stream()
                .map(TicketEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        ticketJpaRepository.deleteAll();
    }

    private BigDecimal calculateTotalPrice(CreateTicket createTicket) {
        var eventEntity = meetupJpaRepository.findById(createTicket.getMeetupId())
                .orElseThrow(() -> new TicketApiDataNotFoundException("ticketapi.meetup.notFound"));

        return eventEntity.getPrice().multiply(BigDecimal.valueOf(createTicket.getCount()));
    }
}
