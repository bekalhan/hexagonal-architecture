package com.kalhan.hexagonal_architecture_three.application.port.input.meetup.usecase;

import com.kalhan.hexagonal_architecture_three.domain.common.DomainComponent;
import com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase.VoidEmptyUseCaseHandler;
import com.kalhan.hexagonal_architecture_three.application.port.output.meetup.MeetupOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class MeetupAdminUseCaseHandler implements VoidEmptyUseCaseHandler {

    private final MeetupOutputPort meetupOutputPort;

    public void handle() {
        meetupOutputPort.deleteAll();
    }
}