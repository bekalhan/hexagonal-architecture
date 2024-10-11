package com.kalhan.hexagonal_architecture_two.infrastructure.input.eventlistener;

import com.kalhan.hexagonal_architecture_two.domain.event.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEventListenerAdapter {

    @EventListener
    public void handle(final ProductCreatedEvent event){
        log.info("Product created with id " + event.getId() + " at " + event.getDate());
    }

}