package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.reservation.rest;

import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.UseCaseHandler;
import com.kalhan.hexagonal_architecture_three.domain.reservation.usecase.TicketReserve;
import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.adapter.BaseRestAdapter;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.reservation.rest.data.request.ReserveTicketRequest;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.reservation.rest.data.response.ReserveTicketResponse;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.data.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
public class ReservationRestAdapter extends BaseRestAdapter {

    private final UseCaseHandler<Ticket, TicketReserve> reserveTicketUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<ReserveTicketResponse> reserveTicket(@Valid @RequestBody ReserveTicketRequest reserveTicketRequest) {
        var reservedTicket = reserveTicketUseCaseHandler.handle(reserveTicketRequest.toModel());
        return respond(ReserveTicketResponse.fromModel(reservedTicket));
    }
}