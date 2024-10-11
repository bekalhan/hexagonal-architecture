package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.reservation.rest.data.response;
import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveTicketResponse {

    private Long id;
    private Long accountId;
    private Long meetupId;
    private LocalDateTime reserveDate;
    private BigDecimal price;
    private Integer count;

    public static ReserveTicketResponse fromModel(Ticket ticket) {
        return ReserveTicketResponse.builder()
                .id(ticket.getId())
                .accountId(ticket.getAccountId())
                .meetupId(ticket.getMeetupId())
                .reserveDate(ticket.getReserveDate())
                .price(ticket.getPrice())
                .count(ticket.getCount())
                .build();
    }
}