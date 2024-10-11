package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.meetup.jpa.entity;

import com.kalhan.hexagonal_architecture_three.domain.meetup.model.Meetup;
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
@Table(name = "meetup")
@Where(clause = "status <> -1")
public class MeetupEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String website;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    public Meetup toModel() {
        return Meetup.Builder.newBuilder()
                .id(super.getId())
                .name(name)
                .website(website)
                .eventDate(eventDate)
                .price(price)
                .build();
    }
}