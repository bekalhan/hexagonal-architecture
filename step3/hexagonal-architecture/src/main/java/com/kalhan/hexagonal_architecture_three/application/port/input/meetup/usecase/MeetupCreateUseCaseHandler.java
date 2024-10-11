package com.kalhan.hexagonal_architecture_three.application.port.input.meetup.usecase;


import com.kalhan.hexagonal_architecture_three.domain.common.DomainComponent;
import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.UseCaseHandler;
import com.kalhan.hexagonal_architecture_three.application.port.output.meetup.MeetupOutputPort;
import com.kalhan.hexagonal_architecture_three.domain.meetup.model.Meetup;
import com.kalhan.hexagonal_architecture_three.domain.meetup.usecase.MeetupCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class MeetupCreateUseCaseHandler implements UseCaseHandler<Meetup, MeetupCreate> {

    private final MeetupOutputPort meetupOutputPort;

    public Meetup handle(MeetupCreate useCase) {
        return meetupOutputPort.create(useCase);
    }
}