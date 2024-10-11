package com.kalhan.hexagonal_architecture_three.application.service;

import com.kalhan.hexagonal_architecture_three.application.port.output.meetup.MeetupOutputPort;
import com.kalhan.hexagonal_architecture_three.domain.common.model.Status;
import com.kalhan.hexagonal_architecture_three.domain.meetup.model.Meetup;
import com.kalhan.hexagonal_architecture_three.domain.meetup.usecase.MeetupCreate;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.jpa.entity.MeetupEntity;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.jpa.repository.MeetupJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetupService implements MeetupOutputPort {
    private final MeetupJpaRepository meetupJpaRepository;

    @Override
    public Meetup retrieve(Long id) {
        return meetupJpaRepository.findById(id)
                .map(MeetupEntity::toModel)
                .orElseThrow();
//                .orElseThrow(() -> new TicketApiDataNotFoundException("ticketapi.meetup.notFound"));
    }

    @Override
    public Meetup create(MeetupCreate meetupCreate) {
        var meetupEntity = new MeetupEntity();
        meetupEntity.setName(meetupCreate.getName());
        meetupEntity.setWebsite(meetupCreate.getWebsite());
        meetupEntity.setEventDate(meetupCreate.getEventDate());
        meetupEntity.setPrice(meetupCreate.getPrice());
        meetupEntity.setStatus(Status.ACTIVE);
        return meetupJpaRepository.save(meetupEntity).toModel();
    }

    @Override
    public void deleteAll() {
        meetupJpaRepository.deleteAll();
    }
}
