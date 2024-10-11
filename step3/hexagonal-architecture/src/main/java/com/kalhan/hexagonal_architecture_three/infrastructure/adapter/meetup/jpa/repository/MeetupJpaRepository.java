package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.jpa.repository;

import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.jpa.entity.MeetupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetupJpaRepository extends JpaRepository<MeetupEntity, Long> {
}