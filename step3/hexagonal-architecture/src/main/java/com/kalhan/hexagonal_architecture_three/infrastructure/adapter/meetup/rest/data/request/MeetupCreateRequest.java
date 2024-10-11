package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.rest.data.request;

import com.kalhan.hexagonal_architecture_three.domain.meetup.usecase.MeetupCreate;
import jakarta.validation.constraints.NotNull;
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
public class MeetupCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private String website;

    @NotNull
    private BigDecimal price;

    @NotNull
    private LocalDateTime eventDate;

    public MeetupCreate toUseCase() {
        return MeetupCreate.Builder.newBuilder()
                .name(name)
                .website(website)
                .price(price)
                .eventDate(eventDate)
                .build();
    }
}