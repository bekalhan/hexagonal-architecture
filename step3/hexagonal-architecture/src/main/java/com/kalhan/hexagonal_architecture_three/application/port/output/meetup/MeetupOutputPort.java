package com.kalhan.hexagonal_architecture_three.application.port.output.meetup;

import com.kalhan.hexagonal_architecture_three.domain.meetup.model.Meetup;
import com.kalhan.hexagonal_architecture_three.domain.meetup.usecase.MeetupCreate;

public interface MeetupOutputPort {
    Meetup retrieve(Long id);

    Meetup create(MeetupCreate meetupCreate);

    void deleteAll();
}
