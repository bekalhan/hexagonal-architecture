package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.rest.data.response;

import com.kalhan.hexagonal_architecture_three.domain.meetup.model.Meetup;
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
public class MeetupResponse {

    private Long id;
    private String name;
    private String website;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public static MeetupResponse from(Meetup meetup) {
        return MeetupResponse.builder()
                .id(meetup.getId())
                .name(meetup.getName())
                .website(meetup.getWebsite())
                .price(meetup.getPrice())
                .eventDate(meetup.getEventDate())
                .build();
    }
}