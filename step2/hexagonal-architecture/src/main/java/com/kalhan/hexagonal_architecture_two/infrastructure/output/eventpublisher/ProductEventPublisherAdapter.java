package com.kalhan.hexagonal_architecture_two.infrastructure.output.eventpublisher;

import com.kalhan.hexagonal_architecture_two.application.port.output.ProductEventPublisher;
import com.kalhan.hexagonal_architecture_two.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(final ProductCreatedEvent event) {
        this.applicationEventPublisher.publishEvent(event);
    }
}
