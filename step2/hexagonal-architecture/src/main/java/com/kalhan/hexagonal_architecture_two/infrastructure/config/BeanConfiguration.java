package com.kalhan.hexagonal_architecture_two.infrastructure.config;

import com.kalhan.hexagonal_architecture_two.application.service.ProductService;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.eventpublisher.ProductEventPublisherAdapter;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.ProductPersistenceAdapter;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.mapper.ProductPersistenceMapper;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.repository.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(final ProductRepository productRepository, final ProductPersistenceMapper productPersistenceMapper) {
        return new ProductPersistenceAdapter(productRepository, productPersistenceMapper);
    }

    @Bean
    public ProductEventPublisherAdapter productEventPublisherAdapter(final ApplicationEventPublisher applicationEventPublisher) {
        return new ProductEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ProductService productService(final ProductPersistenceAdapter productPersistenceAdapter, final ProductEventPublisherAdapter productEventPublisherAdapter) {
        return new ProductService(productPersistenceAdapter, productEventPublisherAdapter);
    }

}
