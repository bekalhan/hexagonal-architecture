package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.rest;


import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.UseCaseHandler;
import com.kalhan.hexagonal_architecture_three.domain.meetup.model.Meetup;
import com.kalhan.hexagonal_architecture_three.domain.meetup.usecase.MeetupCreate;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.rest.data.request.MeetupCreateRequest;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.rest.data.response.MeetupResponse;
import com.kalhan.hexagonal_architecture_three.infrastructure.common.rest.BaseRestAdapter;
import com.kalhan.hexagonal_architecture_three.infrastructure.common.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/meetups")
public class MeetupRestAdapter extends BaseRestAdapter {

    private final UseCaseHandler<Meetup, MeetupCreate> meetupMeetupCreateUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<MeetupResponse> createMeetup(@Valid @RequestBody MeetupCreateRequest meetupCreateRequest){
        var meetup = meetupMeetupCreateUseCaseHandler.handle(meetupCreateRequest.toUseCase());
        return respond(MeetupResponse.from(meetup));
    }

}
