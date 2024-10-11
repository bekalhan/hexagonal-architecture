package com.kalhan.hexagonal_architecture_two.application.port.output;

import com.kalhan.hexagonal_architecture_two.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {
    void publishProductCreatedEvent(ProductCreatedEvent event);
}
