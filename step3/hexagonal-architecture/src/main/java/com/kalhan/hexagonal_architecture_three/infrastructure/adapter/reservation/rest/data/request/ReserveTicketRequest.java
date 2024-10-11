package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.reservation.rest.data.request;


import com.kalhan.hexagonal_architecture_three.domain.reservation.usecase.TicketReserve;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveTicketRequest {

    @NotNull
    @Positive
    private Long accountId;

    @NotNull
    @Positive
    private Long meetupId;

    @NotNull
    @Positive
    private Integer count;

    private String referenceCode;

    public TicketReserve toModel() {
        return TicketReserve.Builder.newBuilder()
                .accountId(accountId)
                .meetupId(meetupId)
                .count(count)
                .referenceCode(calculateReferenceCode())
                .build();
    }

    private String calculateReferenceCode() {
        return Optional.ofNullable(referenceCode)
                .orElse(UUID.randomUUID().toString());
    }
}