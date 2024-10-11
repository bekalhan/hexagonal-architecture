package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.rest;

import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.UseCaseHandler;
import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import com.kalhan.hexagonal_architecture_three.domain.ticket.usecase.TicketRetrieve;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.adapter.BaseRestAdapter;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.data.response.DataResponse;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.data.response.Response;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.rest.data.response.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
public class TicketRestAdapter extends BaseRestAdapter {

    private final UseCaseHandler<List<Ticket>, TicketRetrieve> retrieveTicketUseCaseHandler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<DataResponse<TicketResponse>> retrieveTicket(@RequestParam Long accountId) {
        List<Ticket> retrieveTickets = retrieveTicketUseCaseHandler.handle(toUseCase(accountId));
        return respond(toResponse(retrieveTickets));
    }

    private List<TicketResponse> toResponse(List<Ticket> retrieveTickets) {
        return retrieveTickets.stream().map(TicketResponse::from).collect(Collectors.toList());
    }

    private TicketRetrieve toUseCase(Long accountId) {
        return TicketRetrieve.Builder.newBuilder().accountId(accountId).build();
    }
}