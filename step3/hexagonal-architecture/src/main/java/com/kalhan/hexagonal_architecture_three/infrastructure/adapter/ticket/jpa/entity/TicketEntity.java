package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.ticket.jpa.entity;

import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;
import com.kalhan.hexagonal_architecture_three.infrastructure.output.presistence.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket")
@Where(clause = "status <> -1")
public class TicketEntity extends AbstractEntity {

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private LocalDateTime reserveDate;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private Long meetupId;

    public Ticket toModel() {
        return Ticket.Builder.newBuilder()
                .id(super.getId())
                .accountId(accountId)
                .meetupId(meetupId)
                .reserveDate(reserveDate)
                .price(price)
                .count(count)
                .build();
    }
}
