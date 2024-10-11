package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.jpa.repository;

import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.jpa.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, Long> {

    List<TicketEntity> findAllByAccountId(Long accountId);
}