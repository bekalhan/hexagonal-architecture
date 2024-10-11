package com.kalhan.hexagonal_architecture_three.application.port.input.reservation;


import com.kalhan.hexagonal_architecture_three.domain.common.DomainComponent;
import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.UseCaseHandler;
import com.kalhan.hexagonal_architecture_three.application.port.output.account.AccountOutputPort;
import com.kalhan.hexagonal_architecture_three.application.port.output.meetup.MeetupOutputPort;
import com.kalhan.hexagonal_architecture_three.application.port.output.payment.PaymentOutputPort;
import com.kalhan.hexagonal_architecture_three.application.port.output.payment.PaymentRollbackEventPort;
import com.kalhan.hexagonal_architecture_three.application.port.output.reservation.TicketReservedEventPort;
import com.kalhan.hexagonal_architecture_three.application.port.output.ticket.TicketOutputPort;
import com.kalhan.hexagonal_architecture_three.domain.payment.event.PaymentRollbackEvent;
import com.kalhan.hexagonal_architecture_three.domain.payment.usecase.PaymentCreate;
import com.kalhan.hexagonal_architecture_three.domain.reservation.usecase.TicketReserve;
import com.kalhan.hexagonal_architecture_three.domain.ticket.event.TicketReservedEvent;
import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import com.kalhan.hexagonal_architecture_three.domain.ticket.usecase.CreateTicket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class TicketReserveUseCaseHandler implements UseCaseHandler<Ticket, TicketReserve> {
    private final MeetupOutputPort meetupOutputPort;
    private final TicketOutputPort ticketOutputPort;
    private final PaymentOutputPort paymentOutputPort;
    private final AccountOutputPort accountOutputPort;
    private final TicketReservedEventPort reservationNotificationPort;
    private final PaymentRollbackEventPort paymentRollbackNotificationPort;

    public Ticket handle(TicketReserve useCase) {
        var account = accountOutputPort.retrieve(useCase.getAccountId());
        var event = meetupOutputPort.retrieve(useCase.getMeetupId());

        var payment = paymentOutputPort.pay(buildCreatePayment(account.getId(), event.getPrice(), useCase.getCount(), useCase.getReferenceCode()));
        log.debug("Ticket price payed by account {} as {}", account.getId(), payment.getPrice());

        try {
            var createdTicket = ticketOutputPort.create(buildCreateTicket(useCase));
            log.debug("Ticket price reserved by account {}", account.getId());

            reservationNotificationPort.publish(TicketReservedEvent.from(createdTicket, payment));
            log.debug("Ticket create event is sent for ticket {}", createdTicket);

            return createdTicket;
        } catch (Exception e) {
            log.error("Ticket cannot be created due to errors, payment will rollback.", e);
            paymentRollbackNotificationPort.publish(PaymentRollbackEvent.from(payment));

            throw new RuntimeException("ticketapi.ticket.cannotBeCreated");
        }
    }

    private CreateTicket buildCreateTicket(TicketReserve ticketReserve) {
        return CreateTicket.Builder.newBuilder()
                .accountId(ticketReserve.getAccountId())
                .count(ticketReserve.getCount())
                .meetupId(ticketReserve.getMeetupId())
                .referenceCode(ticketReserve.getReferenceCode())
                .build();
    }

    private PaymentCreate buildCreatePayment(Long accountId, BigDecimal eventPrice, Integer ticketCount, String referenceCode) {
        return PaymentCreate.Builder.newBuilder()
                .accountId(accountId)
                .referenceCode(referenceCode)
                .price(eventPrice.multiply(BigDecimal.valueOf(ticketCount)))
                .build();
    }


}
