package com.kalhan.hexagonal_architecture_three.domain.common.event;

import com.kalhan.hexagonal_architecture_three.domain.common.model.Event;

public interface EventPublisher<T extends Event> {
    void publish(T event);
}

